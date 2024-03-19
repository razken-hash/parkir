package com.example.parkir.views.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.white

@Composable
fun ParkirButton(
    label: String,
    labelColor: Color = white,
    bgColor: Color = primary,
    onClick: () -> Unit,
    height: Int = 58,
    width: Int = Int.MAX_VALUE
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = height.dp),
        colors = ButtonDefaults.buttonColors(containerColor = bgColor, contentColor = labelColor)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleSmall,
        )
    }
}