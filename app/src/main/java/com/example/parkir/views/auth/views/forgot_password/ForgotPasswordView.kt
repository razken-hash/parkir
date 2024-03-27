package com.example.parkir.views.auth.views.forgot_password

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.auth.views.composables.OAuthSection
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.BackUpBar
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.theme.grey13
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.primary1A

@Composable
fun ForgotPasswordView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        BackUpBar(title = "Forgot Password", navController = navController)

        Image(
            painter = painterResource(id = R.drawable.security),
            contentDescription = "Recover Password",
            modifier = Modifier
                .height(250.dp)
                .padding(20.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "Select which contact details should we use to reset your password",
            style = MaterialTheme.typography.bodyLarge,
        )

        var selectedWay by remember {
            mutableStateOf("SMS")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = if (selectedWay == "SMS") 2.dp else 1.dp,
                    color = if (selectedWay == "SMS") primary else grey13,
                    shape = RoundedCornerShape(size = 15.dp)
                )
                .clip(RoundedCornerShape(size = 15.dp))
                .clickable {
                    selectedWay = "SMS"
                }
                .padding(15.dp)

        ) {
            Box(
                modifier = Modifier
                    .size(75.dp)
                    .clip(CircleShape)
                    .background(primary1A)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chat_bold),
                    contentDescription = "SMS",
                    colorFilter = ColorFilter.tint(
                        primary
                    ),
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.Center)

                )
            }
            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Text(text = "Via SMS", style = MaterialTheme.typography.bodyLarge)
                Text(text = "+213 5 -------3", style = MaterialTheme.typography.labelLarge)
            }

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = if (selectedWay == "Email") 2.dp else 1.dp,
                    color = if (selectedWay == "Email") primary else grey13,
                    shape = RoundedCornerShape(size = 15.dp)
                )
                .clip(RoundedCornerShape(size = 15.dp))
                .clickable {
                    selectedWay = "Email"
                }
                .padding(15.dp)

        ) {
            Box(
                modifier = Modifier
                    .size(75.dp)
                    .clip(CircleShape)
                    .background(primary1A),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.message_bold),
                    contentDescription = "Email",
                    colorFilter = ColorFilter.tint(
                        primary
                    ),
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.Center)

                )
            }
            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Text(text = "Via Email", style = MaterialTheme.typography.bodyLarge)
                Text(text = "ka---------@---.dz", style = MaterialTheme.typography.labelLarge)
            }

        }

        ParkirButton(label = "Continue", onClick = {
            navController.navigate(Router.OTPScreen.route)
        })

    }
}