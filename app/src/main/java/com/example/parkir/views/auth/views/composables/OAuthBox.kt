package com.example.parkir.views.auth.views.composables


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.parkir.R
import com.example.parkir.views.ui.theme.grey06

@Composable
fun OAuthBox() {
    Row(
        horizontalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .size(width = 90.dp, height = 60.dp)
                .border(width = 2.dp, color = grey06, shape = RoundedCornerShape(size = 16.dp)),

            ) {
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Facebook",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .size(width = 90.dp, height = 60.dp)
                .border(width = 2.dp, color = grey06, shape = RoundedCornerShape(size = 16.dp)),

            ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)

            )
        }
        Box(
            modifier = Modifier
                .size(width = 90.dp, height = 60.dp)
                .border(width = 2.dp, color = grey06, shape = RoundedCornerShape(size = 16.dp)),
        ) {
            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = "Apple",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)

            )
        }
    }
}