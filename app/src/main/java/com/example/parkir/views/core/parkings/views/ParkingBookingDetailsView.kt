package com.example.parkir.views.core.parkings.views

import android.icu.util.Calendar
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.views.core.bookings.views.BookingsViewModel
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.BackUpBar
import com.example.parkir.views.ui.composables.InfiniteCircularList
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.utils.TimeConsts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ParkingBookingDetailsScreen(
    navController: NavHostController,
    parkingsViewModel: ParkingsViewModel,
    bookingsViewModel: BookingsViewModel
) {

    fun lastDayInMonth(month: Int, year: Int): Int {
        if (month != 2) {
            if (month in listOf<Int>(4, 6, 9, 11)) {
                return 30
            }
            return 31
        }
        if (year % 4 == 0) {
            return 29
        }
        return 28;
    }

    var time by remember {
        mutableStateOf(LocalDateTime.now())
    }

    var lastDayInMonth by remember {
        mutableStateOf(31)
    }

    val months = listOf<String>(
        "JANUARY",
        "FEBRUARY",
        "MARCH",
        "APRIL",
        "MAY",
        "JUNE",
        "JULY",
        "AUGUST",
        "SEPTEMBER",
        "OCTOBER",
        "NOVEMBER",
        "DECEMBER",
    )

    var duration by remember {
        mutableStateOf(1f)
    }

    fun adjustDay(month: Int, year: Int) {
        val newLastDayInMonth = lastDayInMonth(month, year)
        if (lastDayInMonth != newLastDayInMonth) {
            lastDayInMonth = newLastDayInMonth
            if (time.dayOfMonth > newLastDayInMonth) {
                time = time.withDayOfMonth(lastDayInMonth)
            }
        }
    }


    LaunchedEffect(1) {
        lastDayInMonth = lastDayInMonth(TimeConsts.currentMonth, TimeConsts.currentYear)
        CoroutineScope(Dispatchers.IO).launch {
            parkingsViewModel.getParkingSpotById(parkingSpotId = 1)
            bookingsViewModel.newBooking.duration =
                "PT${duration.toInt().toString().padStart(2, '0')}H"
            bookingsViewModel.newBooking.beginTime = "${
                time.hour.toString().padStart(2, '0')
            }:${(time.minute - time.minute % 5).toString().padStart(2, '0')}:00"
            bookingsViewModel.newBooking.date = "${time.year}-${
                time.monthValue.toString().padStart(2, '0')
            }-${time.dayOfMonth.toString().padStart(2, '0')}"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        BackUpBar(title = "Book Parking Details", navController = navController)
        Text(text = "Select Date", style = MaterialTheme.typography.titleLarge)
        Row(
            modifier = Modifier
                .background(Color.Transparent, shape = RoundedCornerShape(10))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {


            InfiniteCircularList(
                width = 50.dp,
                itemHeight = 35.dp,
                items = (1..lastDayInMonth).toMutableList(),
                initialItem = time.dayOfMonth,
                textStyle = MaterialTheme.typography.titleMedium,
                textColor = Color.LightGray,
                selectedTextColor = Color.Black
            ) { i, item ->
                time = time.withDayOfMonth(item)
                bookingsViewModel.newBooking.date = "${time.year}-${
                    time.monthValue.toString().padStart(2, '0')
                }-${time.dayOfMonth.toString().padStart(2, '0')}"
            }

            InfiniteCircularList(
                width = 80.dp,
                itemHeight = 35.dp,
                items = months.map { it.substring(0..2) },
                initialItem = months[TimeConsts.currentMonth - 1],
                textStyle = MaterialTheme.typography.titleMedium,
                textColor = Color.LightGray,
                selectedTextColor = Color.Black
            ) { i, item ->
                time = time.withMonth(i + 1)
                adjustDay(time.monthValue, time.year)
                bookingsViewModel.newBooking.date = "${time.year}-${time.monthValue.toString().padStart(2, '0')}-${time.dayOfMonth.toString().padStart(2, '0')}"     }
            InfiniteCircularList(
                width = 80.dp,
                itemHeight = 35.dp,
                items = (TimeConsts.currentYear - 1..TimeConsts.currentYear + 2).toList(),
                initialItem = TimeConsts.currentYear,
                textStyle = MaterialTheme.typography.titleMedium,
                textColor = Color.LightGray,
                selectedTextColor = Color.Black
            ) { i, item ->
                time = time.withYear(item)
                adjustDay(time.monthValue, time.year)
                bookingsViewModel.newBooking.date = "${time.year}-${time.monthValue.toString().padStart(2, '0')}-${time.dayOfMonth.toString().padStart(2, '0')}"   }
        }

        Text("$time")


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Text(
                text = "Start Hour",
                modifier = Modifier.weight(1f),

                style = MaterialTheme.typography.titleLarge,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {

                InfiniteCircularList(
                    width = 60.dp,
                    itemHeight = 35.dp,
                    items = (1..12).toMutableList(),
                    initialItem = time.hour % 12,
                    textStyle = MaterialTheme.typography.titleMedium,
                    textColor = Color.LightGray,
                    selectedTextColor = Color.Black,
                ) { i, item ->
                    time.withHour(item)
                    bookingsViewModel.newBooking.beginTime = "${
                        time.hour.toString().padStart(2, '0')
                    }:${(time.minute - time.minute % 5).toString().padStart(2, '0')}:00"
                }

                InfiniteCircularList(
                    width = 60.dp,
                    itemHeight = 35.dp,
                    items = (0..55 step 5).toList(),
                    initialItem = time.minute - time.minute % 5,
                    textStyle = MaterialTheme.typography.titleMedium,
                    textColor = Color.LightGray,
                    selectedTextColor = Color.Black,
                ) { i, item ->
                    time.withMinute(item)
                    bookingsViewModel.newBooking.beginTime = "${
                        time.hour.toString().padStart(2, '0')
                    }:${(time.minute - time.minute % 5).toString().padStart(2, '0')}:00"

                }
                InfiniteCircularList(
                    width = 70.dp,
                    itemHeight = 35.dp,
                    items = listOf<String>("AM", "PM"),
                    initialItem = "AM",
                    textStyle = MaterialTheme.typography.titleMedium,
                    textColor = Color.LightGray,
                    selectedTextColor = Color.Black,
                ) { i, item ->

                }
            }
        }

        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = "Duration", style = MaterialTheme.typography.titleLarge)
                Text(text = "${duration.toInt()} Hrs", style = MaterialTheme.typography.titleLarge)
            }

            Slider(
                value = duration / 10,
                onValueChange = {
                    duration = it * 10
                    if (duration < 1f) {
                        duration = 1f
                    }
                    bookingsViewModel.newBooking.duration =
                        "PT${duration.toInt().toString().padStart(2, '0')}H"
                },
                colors = SliderDefaults.colors(
                    thumbColor = primary,
                    activeTickColor = primary,
                    activeTrackColor = primary,
                ),
                steps = 10,
            )
        }

        Text(text = "Total", style = MaterialTheme.typography.titleLarge)

        Row(
            verticalAlignment = Alignment.Bottom,
        ) {
            Text(
                text = "${duration.toInt() * parkingsViewModel.selectedParking!!.pricePerHour}",
                color = primary,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = " / ${duration.toInt()} hours",
                color = grey,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Divider()

        ParkirButton(label = "Continue", onClick = {
            bookingsViewModel.newBooking.parkingSpot = parkingsViewModel.selectedParkingSpot!!
            navController.navigate(Router.PaymentMethodsScreen.route)
        })
    }
}
