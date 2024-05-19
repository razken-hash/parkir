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
import com.example.parkir.views.core.bookings.views.BookingsViewModel
import com.example.parkir.views.core.parkings.views.ParkingsViewModel
import com.example.parkir.views.on_boarding.views.OnBoardingView

class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModel.Factory((application as ParkirApplication).authRepository)
    }

    private val parkingsViewModel: ParkingsViewModel by viewModels {
        ParkingsViewModel.Factory((application as ParkirApplication).parkingRepository)
    }

    private val bookingsViewModel: BookingsViewModel by viewModels {
        BookingsViewModel.Factory((application as ParkirApplication).bookingsRepository)
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

                    NavigationHost(
                        navController = navController,
                        authViewModel = authViewModel,
                        parkingsViewModel = parkingsViewModel,
                        bookingsViewModel = bookingsViewModel,
                    )
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