package com.example.parkir.views.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.parkir.views.ui.theme.red
import com.example.parkir.views.ui.theme.white

@Composable
fun ParkingIcon() {
    Box(
        modifier = Modifier
            .size(40.dp)
            .border(width = 6.dp, color = red.copy(alpha = 0.3f), shape = CircleShape)
            .padding(6.dp)
            .background(red, shape = CircleShape),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "P", style = MaterialTheme.typography.titleLarge, color = white)
    }
}