package com.example.parkir.views.core.parkings.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.parkir.views.ui.composables.ParkingIcon
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.primary

@Composable
fun ParkingCard(

) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ParkingIcon()
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(text = "Campion cottages", style = MaterialTheme.typography.titleMedium)
            Text(text = "1342 Antonietta Rest", style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.End,
        ) {
            Text(text = "1km", style = MaterialTheme.typography.titleMedium)
            Row(
                verticalAlignment = Alignment.Bottom,
            ) {

                Text(
                    text = "$2.22",
                    color = primary,
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = " /hours",
                    color = grey,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}