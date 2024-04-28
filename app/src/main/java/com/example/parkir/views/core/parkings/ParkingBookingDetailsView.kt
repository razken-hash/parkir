package com.example.parkir.views.core.parkings

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collection.mutableVectorOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.substring
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.ui.composables.BackUpBar
import com.example.parkir.views.ui.composables.InfiniteCircularList
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.composables.ParkirField
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.grey02
import com.example.parkir.views.ui.theme.grey06
import com.example.parkir.views.ui.theme.grey13
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.utils.TimeConsts
import java.time.LocalDate
import java.util.Calendar
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ParkingBookingDetailsScreen(navController: NavHostController) {

    fun lastDayInMonth(month: Int, year: Int): Int {
        Log.d("MyLogger", "Message $month")
        Log.d("MyLogger", "Message $year")
        if (month != 2) {
            if (month in listOf<Int>(4, 6, 9, 11)) {
                return 30
            }
            return 31
        }
        if (year % 4 == 0) {
            return 29
        }
        Log.d("MyLogger", "Message $29")
        return 28;
    }

    var selectedDate by remember {
        mutableStateOf(LocalDate.now())
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


    fun adjustDay(month: Int, year: Int) {
        val newLastDayInMonth = lastDayInMonth(month, year)
        if (lastDayInMonth != newLastDayInMonth) {
            lastDayInMonth = newLastDayInMonth
            if (selectedDate.dayOfMonth > newLastDayInMonth) {
                Log.d("MyLogger", "I am here")
                selectedDate = selectedDate.withDayOfMonth(lastDayInMonth)
            }
        }
    }

    LaunchedEffect(1) {
        lastDayInMonth = lastDayInMonth(TimeConsts.currentMonth, TimeConsts.currentYear)
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

            InfiniteCircularList(width = 50.dp,
                itemHeight = 35.dp,
                items = (1..lastDayInMonth).toMutableList(),
                initialItem = selectedDate.dayOfMonth,
                textStyle = MaterialTheme.typography.titleMedium,
                textColor = Color.LightGray,
                selectedTextColor = Color.Black,
                onItemSelected = { i, item ->
                    selectedDate = selectedDate.withDayOfMonth(item)
                })

            InfiniteCircularList(width = 80.dp,
                itemHeight = 35.dp,
                items = months.map { it.substring(0..2) },
                initialItem = months[TimeConsts.currentMonth - 1],
                textStyle = MaterialTheme.typography.titleMedium,
                textColor = Color.LightGray,
                selectedTextColor = Color.Black,
                onItemSelected = { i, item ->
                    selectedDate = selectedDate.withMonth(i + 1)
                    adjustDay(selectedDate.monthValue, selectedDate.year)
                })
            InfiniteCircularList(width = 80.dp,
                itemHeight = 35.dp,
                items = (TimeConsts.currentYear - 1..TimeConsts.currentYear + 2).toList(),
                initialItem = TimeConsts.currentYear,
                textStyle = MaterialTheme.typography.titleMedium,
                textColor = Color.LightGray,
                selectedTextColor = Color.Black,
                onItemSelected = { i, item ->
                    selectedDate = selectedDate.withYear(item)
                    adjustDay(selectedDate.monthValue, selectedDate.year)
                })
        }

        Column {
            Text(text = "Duration", style = MaterialTheme.typography.titleLarge)

            var nbHour by remember {
                mutableStateOf(1f)
            }

            Slider(
                value = nbHour / 10,
                onValueChange = {
                    nbHour = it * 10
                },
                colors = SliderDefaults.colors(
                    thumbColor = primary,
                    activeTickColor = primary,
                    activeTrackColor = primary,
                ),
                steps = 10,
            )
        }

        Row {
            Text(

                text = "Start Hour",
                modifier = Modifier.weight(1f),

                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = "End Hour",
                modifier = Modifier.weight(1f),

                style = MaterialTheme.typography.titleLarge,
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ParkirField(
                value = "09:00 AM",
                onValueChange = {},
                trailingIconId = R.drawable.clock_outline,
                modifier = Modifier.weight(1f),
            )
            Image(
                painter = painterResource(id = R.drawable.arrow_right_bold),
                contentDescription = "Parking Screen",
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(10))
                    .padding(10.dp),
            )

            ParkirField(
                value = "09:00 AM",
                onValueChange = {},
                trailingIconId = R.drawable.clock_outline,
                modifier = Modifier.weight(1f),
            )
        }

        Text(text = "Total", style = MaterialTheme.typography.titleLarge)

        Row(
            verticalAlignment = Alignment.Bottom,
        ) {

            Text(
                text = "$8.00",
                color = primary,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = " / 4 hours",
                color = grey,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Divider()

        ParkirButton(label = "Continue", onClick = {})

    }


}
