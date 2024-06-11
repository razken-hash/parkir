package com.example.parkir

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.parkir.views.ui.theme.ParkirTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.parkir.views.auth.views.AuthViewModel
import com.example.parkir.views.core.bookings.views.BookingsViewModel
import com.example.parkir.views.core.parkings.views.ParkingsViewModel
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.parkir.views.router.NavigationHost

class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModel.Factory((application as ParkirApplication).authRepository)
    }

    private val parkingsViewModel: ParkingsViewModel by viewModels {
        ParkingsViewModel.Factory((application as ParkirApplication).parkingRepository)
    }

    private val bookingsViewModel: BookingsViewModel by viewModels {
        BookingsViewModel.Factory(
            (application as ParkirApplication).bookingsRepository,
            (application as ParkirApplication).paymentRepository
        )
    }

    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT > -Build.VERSION_CODES.TIRAMISU) {
            val hasPermission = ContextCompat.checkSelfPermission(
                this, android.Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
            if (!hasPermission) {
                ActivityCompat.requestPermissions(
                    this, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 0
                )
            }
        }
    }

    @RequiresApi(34)
    override fun onCreate(savedInstanceState: Bundle?) {
        requestNotificationPermission();
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ParkirTheme {
                val context = LocalContext.current;

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