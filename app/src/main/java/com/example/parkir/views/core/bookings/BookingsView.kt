package com.example.parkir.views.core.bookings

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.theme.green
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.white

@Composable
fun BookingsView(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.parkir),
                    contentDescription = "Parkir",
                    modifier = Modifier.size(35.dp),
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "My Bookings", style = MaterialTheme.typography.displaySmall,
                )
            }
            Image(
                painter = painterResource(id = R.drawable.loop_outline),
                contentDescription = "loop",
                modifier = Modifier.size(25.dp),
            )
        }

        val scrollState = rememberScrollState()


        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            ParkirButton(
                label = "On going",
                onClick = {},
                bgColor = white,
                labelColor = primary,
                borderColor = primary,
                modifier = Modifier
                    .width(140.dp)
                    .height(35.dp),
            )
            ParkirButton(
                label = "Completed", onClick = {},
                modifier = Modifier
                    .width(140.dp)
                    .height(35.dp),

                )
            ParkirButton(
                label = "Canceled", onClick = {}, bgColor = white, labelColor = primary,
                borderColor = primary,

                modifier = Modifier
                    .width(140.dp)
                    .height(35.dp),

                )
        }

        val bookingsScrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(bookingsScrollState)
        ) {
            for (i in 1..10) {
                Row(

                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 2.dp,
                            color = grey,
                            shape = RoundedCornerShape(5.dp),
                        )
                        .padding(10.dp)
                ) {
                    Column {
                        Text(text = "Allington Poddock")
                        Text(text = "982 Linden Trail")
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(text = "$6.48", color = primary)
                            Text(text = "/ 6 hours", color = grey)
                            Text(
                                text = "Completed",
                                color = green,
                                modifier = Modifier
                                    .border(
                                        width = 2.dp,
                                        color = green,
                                        shape = RoundedCornerShape(5.dp),
                                    )
                                    .padding(10.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
            }
        }

    }
}