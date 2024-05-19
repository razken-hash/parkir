package com.example.parkir.views.core.bookings.views.composables

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.parkir.R
import com.example.parkir.views.core.bookings.data.entity.Booking
import com.example.parkir.views.core.bookings.data.entity.BookingStatus
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.theme.green
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.red
import com.example.parkir.views.ui.theme.white


@Composable
fun BookingCard(navController: NavHostController, booking: Booking) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                white,
                shape = RoundedCornerShape(20.dp),
            )
            .padding(10.dp),
    ) {
        Row(

            verticalAlignment = Alignment.CenterVertically,
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.parking),
//                contentDescription = "Parking Picture",
//                modifier = Modifier
//                    .size(120.dp)
//                    .clip(RoundedCornerShape(size = 30.dp)),
//                contentScale = ContentScale.FillBounds,
//            )

            AsyncImage(
                model = booking.parkingSpot.floor.parking.image,
                contentDescription = "Parking Image",
                modifier =
                Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(size = 30.dp)),
                placeholder = painterResource(id = R.drawable.parking),
                contentScale = ContentScale.FillBounds,
            )

            Spacer(modifier = Modifier.width(15.dp))
            Column(
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                Text(
                    text = booking.parkingSpot.floor.parking.name,
                    style = MaterialTheme.typography.headlineLarge,
                )
                Text(text = booking.parkingSpot.floor.parking.address.street)
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(
                        verticalAlignment = Alignment.Bottom,
                    ) {

                        Text(
                            text = "$6.48",
                            color = primary,
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Text(
                            text = " / 4 hours",
                            color = grey,
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
                    Text(
                        text = booking.status.name,
                        style = MaterialTheme.typography.bodySmall,
                        color = if (booking.status == BookingStatus.Canceled) red else if (booking.status == BookingStatus.Completed) green else primary,
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = if (booking.status == BookingStatus.Canceled) red else if (booking.status == BookingStatus.Completed) green else primary,
                                shape = RoundedCornerShape(percent = 50),
                            )
                            .padding(10.dp, 5.dp)
                    )
                }
            }
        }
        Divider(
            modifier = Modifier.padding(20.dp),
        )

        if (booking.status == BookingStatus.Completed) {
            ParkirButton(
                label = "View Ticket",
                onClick = { },
                modifier = Modifier
                    .height(40.dp),
                labelColor = primary,
                bgColor = white,
                borderColor = primary,
            )
        } else if (booking.status == BookingStatus.Paid || booking.status == BookingStatus.OnGoing) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                ParkirButton(
                    label = "View Ticket",
                    onClick = {
                        navController.navigate(Router.BookingTicketScreen.route)
                    },
                    modifier = Modifier
                        .height(40.dp)
                        .weight(1f),
                    labelColor = primary,
                    bgColor = white,
                    borderColor = primary,
                )
                if (booking.status == BookingStatus.Paid) {
                    ParkirButton(
                        label = "Cancel Booking",
                        onClick = { },
                        modifier = Modifier
                            .height(40.dp)
                            .weight(1f),
                        labelColor = primary,
                        bgColor = white,
                        borderColor = primary,
                    )
                } else {
                    ParkirButton(
                        label = "View Timer",
                        onClick = { },
                        modifier = Modifier
                            .height(40.dp)
                            .weight(1f),
                        height = 40,
                    )
                }
            }

        }


    }
}