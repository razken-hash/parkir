package com.example.parkir.on_boarding.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parkir.on_boarding.model.OnBoardingItem
import com.example.parkir.on_boarding.screens.composables.OnBoardingBox

@Composable
fun OnBoardingScreen() {
    val onBoardingItems: List<OnBoardingItem> = OnBoardingItem.onBoardingItems;
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        OnBoardingBox(onBoardingItem = onBoardingItems[0])
        //IndicatorsBox()

        // Next Button
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    58.dp
                ),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text(text = "Next", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        // Skip Button
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    58.dp
                ),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Text(text = "Skip", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen()
}