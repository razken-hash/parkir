package com.example.parkir.auth.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.parkir.R
import com.example.parkir.composables.ParkirButton
import com.example.parkir.ui.theme.grey
import com.example.parkir.ui.theme.grey06
import com.example.parkir.ui.theme.primary

@Composable
fun AuthView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrow_left_outline),
            contentDescription = "Go Back",
        )
        Text(
            text = "Let's you in",
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            ParkirButton(label = "Login With Phone Number", onClick = { /*TODO*/ })
            ParkirButton(label = "Login With Email", onClick = { /*TODO*/ })
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Divider(
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "  or  ",
                style = MaterialTheme.typography.bodyLarge,
            )
            Divider(
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
//                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Don't have an account? ",
                color = grey,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Register",
                color = primary,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
            )
        }
        Box {}
    }
}