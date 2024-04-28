package com.example.parkir.views.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
    borderColor: Color = bgColor,
    height: Int = 58,
    width: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
            .border(
                BorderStroke(
                    width = 2.dp,
                    color = if (bgColor == borderColor) Color.Transparent else borderColor
                ),
                shape = RoundedCornerShape(percent = 50)
            )
            .then(modifier)
            .fillMaxWidth()
            .height(height = height.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(containerColor = bgColor, contentColor = labelColor)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleSmall,
        )
    }
}