package com.example.parkir.views.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.parkir.R
import com.example.parkir.views.ui.theme.black
import com.example.parkir.views.ui.theme.grey6F
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.white

@Composable
fun ParkirCheckBox(value: Boolean, onClick: () -> Unit) {
    var value by remember {
        mutableStateOf(value)
    }

    Box(
        modifier = Modifier
            .size(20.dp)
            .border(
                width = 3.dp, color = primary, shape = RoundedCornerShape(size = 5.dp)
            )
            .clickable {
                onClick
                value = !value
            }
            .clip(RoundedCornerShape(size = 5.dp))
            .background(if (value) primary else white),
        contentAlignment = Alignment.Center,
    ) {
        if (value) {
            Image(
                painter = painterResource(id = R.drawable.tick),
                contentDescription = "",
                colorFilter = ColorFilter.tint(
                    white
                ),
                modifier = Modifier
                    .size(10.dp),
            )
        }
    }
}