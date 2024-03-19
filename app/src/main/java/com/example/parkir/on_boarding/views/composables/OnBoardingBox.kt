package com.example.parkir.on_boarding.views.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parkir.on_boarding.model.OnBoardingItem

@Composable
fun OnBoardingBox(onBoardingItem: OnBoardingItem) {
    Column (
        modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ){
        Image(
            painter = painterResource(id = onBoardingItem.image),
            contentDescription = onBoardingItem.title,
            modifier = Modifier.height(250.dp).padding(20.dp)
        )
        Text(
            text = onBoardingItem.title,
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center,
        )
        Text(
            text = onBoardingItem.description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
        )
    }
}


@Preview
@Composable
fun OnBoardingBoxPreview() {
    OnBoardingBox(OnBoardingItem.onBoardingItems[0])
}