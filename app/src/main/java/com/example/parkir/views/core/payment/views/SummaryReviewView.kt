package com.example.parkir.views.core.payment.views

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.core.bookings.views.BookingsViewModel
import com.example.parkir.views.core.payment.views.composables.SummaryItem
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.BackUpBar
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.theme.grey02
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.white
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReviewSummaryView(navController: NavHostController, bookingsViewModel: BookingsViewModel) {

    val booking = bookingsViewModel.newBooking

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grey02)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        BackUpBar(title = "Summary Review", navController = navController)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(white, shape = RoundedCornerShape(15.dp))
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            SummaryItem(title = "Parking Area", value = "${booking.parkingSpot!!.floor.parking.name}")
            SummaryItem(title = "Address", value = "${booking.parkingSpot!!.floor.parking.address.street}, ${booking.parkingSpot!!.floor.parking.address.city}")
            SummaryItem(title = "Parking Spot", value = "${booking.parkingSpot!!.floor.number} Floor (${booking.parkingSpot!!.floor.name})")
            SummaryItem(title = "Date", value = "${booking.date}") // Dec. 16, 2023
            SummaryItem(title = "Time", value = "${booking.beginTime}") // 09:00 AM - 01:00 PM
            SummaryItem(title = "Duration", value = "${booking.duration.substring(booking.duration.indexOf("T") + 1, booking.duration.indexOf("H"))} Hours")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(white, shape = RoundedCornerShape(15.dp))
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            SummaryItem(title = "Ammount", value = "${booking.parkingSpot!!.floor.parking.pricePerHour * booking.duration.substring(2, 4).toInt()}")
            SummaryItem(title = "Taxes & Fees", value = "${booking.parkingSpot!!.floor.parking.pricePerHour * booking.duration.substring(2, 4).toInt() * 0.05}")
            Divider()
            SummaryItem(title = "Total", value = "${booking.parkingSpot!!.floor.parking.pricePerHour * booking.duration.substring(2, 4).toInt()} + ${booking.parkingSpot!!.floor.parking.pricePerHour * booking.duration.substring(2, 4).toInt() * 0.05}")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(white, shape = RoundedCornerShape(15.dp))
                .padding(15.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.eddahabia_card),
                contentDescription = "EDDAHABIA Card",
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = "•••• •••• •••• 4679",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f)
            )
            ParkirButton(
                label = "Change",
                labelColor = primary,
                bgColor = white,
                borderColor = white,
                modifier = Modifier.width(100.dp),
                onClick = {
                    navController.navigate(Router.NewCardScreen.route)
                },
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Divider()

        ParkirButton(
            label = "Confirm Payment",
            onClick = {
                CoroutineScope(Dispatchers.IO).launch {
                    bookingsViewModel.bookParking()
                }
                navController.navigate(Router.BookingTicketScreen.createRoute(bookingId = bookingsViewModel.selectedBooking!!.id!!))
            },
        )
    }
}


