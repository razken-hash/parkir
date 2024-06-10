package com.example.parkir.views.auth.views.composables


import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Space
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.MainActivity
import com.example.parkir.R
import com.example.parkir.views.auth.views.AuthViewModel
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.theme.black
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.grey06
import com.example.parkir.views.ui.theme.grey13
import com.example.parkir.views.ui.theme.white
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun OAuthSection(viewMode: Int, navController: NavHostController, authViewModel: AuthViewModel) {
    val context = LocalContext.current
    if (viewMode == 0) Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        OAuthTextButton(icon = R.drawable.facebook, title = "Facebook") {
        }
        OAuthTextButton(icon = R.drawable.google, title = "Google") {
            CoroutineScope(Dispatchers.IO).launch {
                authViewModel.signInWthGoogle(context)
            }
        }
        OAuthTextButton(icon = R.drawable.apple, title = "Apple") {

        }
    }
    else Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        OAuthIconButton(icon = R.drawable.facebook, title = "Facebook") {

        }

        Spacer(modifier = Modifier.width(15.dp))

        OAuthIconButton(
            icon = R.drawable.google, title = "Google",
            onClick = {
                CoroutineScope(Dispatchers.IO).launch {
                    authViewModel.signInWthGoogle(context)
                }
            },
        )

        Spacer(modifier = Modifier.width(15.dp))

        OAuthIconButton(icon = R.drawable.apple, title = "Apple") {

        }


    }

    if (authViewModel.authStatus) {
        LaunchedEffect(Unit) {
            navController.navigate(Router.ParkirNavScreen.route)
        }
    }
}

@Composable
fun OAuthIconButton(
    icon: Int,
    title: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(height = 58.dp, width = 90.dp),
        border = BorderStroke(2.dp, grey13),
        shape = RoundedCornerShape(size = 15.dp),
        colors = ButtonDefaults.buttonColors(containerColor = white, contentColor = black)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = title,
            modifier = Modifier.size(20.dp),
        )
    }
}

@Composable
fun OAuthTextButton(
    icon: Int,
    title: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 58.dp),
        border = BorderStroke(2.dp, grey13),
        shape = RoundedCornerShape(size = 15.dp),
        colors = ButtonDefaults.buttonColors(containerColor = white, contentColor = black)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = title,
                modifier = Modifier.size(20.dp),
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "Continue with $title",
                style = MaterialTheme.typography.titleSmall,
            )
        }
    }
}
