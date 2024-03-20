package com.example.parkir.views.auth.views.forgot_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.composables.ParkirCheckBox
import com.example.parkir.views.ui.composables.ParkirField
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.red
import kotlinx.coroutines.delay
import kotlin.concurrent.timer

@Composable
fun OTPScreen(navController: NavHostController) {

    var char1 by remember {
        mutableStateOf("")
    }

    var seconds by remember { mutableStateOf(59) }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        while (seconds > 0) {
            delay(1000)
            seconds -= 1
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow_left_outline),
                contentDescription = "Go Back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )
            Text(
                text = "Forgot Password",
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center,
            )
        }



        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Code has been sent to +213 5-------3",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(50.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    ParkirField(
                        value = char1,
                        onValueChange = {
                            char1 = it
                        },
                    )
                }
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    ParkirField(
                        value = char1,
                        onValueChange = {
                            char1 = it
                        },
                    )
                }
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    ParkirField(
                        value = char1,
                        onValueChange = {
                            char1 = it
                        },
                    )
                }
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    ParkirField(
                        value = char1,
                        onValueChange = {
                            char1 = it
                        },
                    )
                }
            }
            Spacer(modifier = Modifier.height(25.dp))

            if (seconds > 0)
                Row {
                    Text(
                        text = "Resend code in",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Text(
                        text = " ${"%02d".format(seconds)} ",
                        style = MaterialTheme.typography.bodyLarge,
                        color = primary,
                        modifier = Modifier.width(25.dp)
                    )
                    Text(
                        text = "s",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            else Text(
                text = "Resend Code",
                color = primary,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.clickable {
                }
            )
        }

        ParkirButton(label = "Verify", onClick = {
            navController.navigate(Router.ResetPasswordScreen.route)
        })

    }
}