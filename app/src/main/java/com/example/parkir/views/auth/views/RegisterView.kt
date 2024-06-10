package com.example.parkir.views.auth.views

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.auth.views.composables.OAuthSection
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.BackUpBar
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.composables.ParkirCheckBox
import com.example.parkir.views.ui.composables.ParkirField
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.grey06
import com.example.parkir.views.ui.theme.grey0B
import com.example.parkir.views.ui.theme.grey24
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.primary1A
import com.example.parkir.views.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterView(navController: NavHostController, authViewModel: AuthViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        BackUpBar(title = "", navController = navController)

        Text(
            text = "Create your\naccount",
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Left,
        )

        ParkirField(
            value = authViewModel.email,
            onValueChange = {
                authViewModel.email = it
            },
            placeHolderText = "Email",
            leadingIconId = R.drawable.message_bold,
        )

        ParkirField(
            value = authViewModel.password,
            onValueChange = {
                authViewModel.password = it
            },
            placeHolderText = "Password",
            leadingIconId = R.drawable.lock_bold,
            trailingIconId = R.drawable.show_outline,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ParkirCheckBox(value = authViewModel.rememberMe) {
                authViewModel.rememberMe = !authViewModel.rememberMe
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Remember me")
        }

        ParkirButton(label = "Register", onClick = {
            authViewModel.register();
        })

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

        OAuthSection(viewMode = 1, navController = navController, authViewModel = authViewModel)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Already have an account? ",
                color = grey,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Login",
                color = primary,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable {
                    navController.popBackStack()
                    navController.navigate(Router.LoginScreen.route)
                }
            )
        }
        Box {}

        if (authViewModel.authStatus) {
            LaunchedEffect(Unit) {
                navController.navigate(Router.ParkirNavScreen.route)
            }
        }
    }
}