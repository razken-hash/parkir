package com.example.parkir.views.core.notifications.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.parkir.R
import com.example.parkir.views.ui.composables.shapes.BublleShape
import com.example.parkir.views.ui.theme.green
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.primaryCC
import com.example.parkir.views.ui.theme.white

@Composable
fun NotificationCard(
    title: String,
    subTitle: String,
    icon: Int,
    color: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                white, shape = RoundedCornerShape(20)
            )
            .padding(horizontal =  10.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {

        Box(
            modifier = Modifier
                .size(90.dp)
                .background(
                    Brush.linearGradient(
                        colorStops = arrayOf(
                            0.0f to color.copy(alpha = 0.7f),
                            0.9f to color,
                        ),
                        start = androidx.compose.ui.geometry.Offset.Zero,
                        end = androidx.compose.ui.geometry.Offset.Infinite
                    ), BublleShape(cornerSize = CornerSize(0))
                ),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "",
                modifier = Modifier.size(30.dp),
                colorFilter = ColorFilter.tint(white),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = subTitle,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}