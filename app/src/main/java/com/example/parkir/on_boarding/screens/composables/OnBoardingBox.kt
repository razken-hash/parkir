package com.example.parkir.on_boarding.screens.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parkir.R
import com.example.parkir.on_boarding.model.OnBoardingItem
import com.example.parkir.ui.theme.Urbanist

@Composable
fun OnBoardingBox(onBoardingItem: OnBoardingItem) {
    Column {
        Image(
            painter = painterResource(id = onBoardingItem.image),
            contentDescription = onBoardingItem.title,
            modifier = Modifier.padding(40.dp)
        )
        Text(
            text = onBoardingItem.title,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = Urbanist,
        )
        Text(text = onBoardingItem.description)
    }
}


@Preview
@Composable
fun OnBoardingBoxPreview() {
    OnBoardingBox(OnBoardingItem.onBoardingItems[0])
}