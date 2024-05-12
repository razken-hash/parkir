package com.example.parkir

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.parkir.views.router.NavigationHost
import com.example.parkir.views.ui.theme.ParkirTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.parkir.views.auth.views.AuthViewModel
import com.example.parkir.views.auth.views.LoginView
import com.example.parkir.views.on_boarding.views.OnBoardingView

class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModel.Factory((application as ParkirApplication).authRepository)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ParkirTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavigationHost(navController = navController, authViewModel = authViewModel)
//                    LoginView(authViewModel = authViewModel, navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ParkirTheme {

    }
}