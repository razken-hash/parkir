package com.example.parkir.views.core.parkings

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.ui.composables.BackUpBar
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.composables.ParkirField
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.grey06
import com.example.parkir.views.ui.theme.grey13
import com.example.parkir.views.ui.theme.primary

@Composable
fun ParkingBookingDetailsScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        BackUpBar(title = "Book Parking Details", navController = navController)
        Text(text = "Select Date", style = MaterialTheme.typography.titleLarge)
        Box(
            modifier = Modifier
                .background(grey13, shape = RoundedCornerShape(10))
                .fillMaxWidth()
                .height(200.dp),
        ) {

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

        ParkirButton(label = "Continue", onClick = { })

    }
}