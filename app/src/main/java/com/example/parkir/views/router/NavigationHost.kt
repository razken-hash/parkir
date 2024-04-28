package com.example.parkir.views.router

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.parkir.views.auth.views.AuthView
import com.example.parkir.views.auth.views.LoginView
import com.example.parkir.views.auth.views.RegisterView
import com.example.parkir.views.auth.views.forgot_password.ForgotPasswordView
import com.example.parkir.views.auth.views.forgot_password.OTPScreen
import com.example.parkir.views.auth.views.forgot_password.ResetPasswordView
import com.example.parkir.views.core.bookings.BookingTicketView
import com.example.parkir.views.core.bookings.BookingsView
import com.example.parkir.views.core.home.HomeView
import com.example.parkir.views.core.navigation.ParkirNavView
import com.example.parkir.views.core.notifications.NotificationsView
import com.example.parkir.views.core.bookmarks.BookmarksView
import com.example.parkir.views.core.parkings.ParkingBookingDetailsScreen
import com.example.parkir.views.core.parkings.ParkingDetailsView
import com.example.parkir.views.core.parkings.ParkingsBrowserView
import com.example.parkir.views.core.parkings.ParkingsView
import com.example.parkir.views.core.payment.NewCardView
import com.example.parkir.views.core.payment.PaymentMethodsView
import com.example.parkir.views.core.payment.ReviewSummaryView
import com.example.parkir.views.core.profile.EditProfileView
import com.example.parkir.views.core.profile.NotificationsSettingsView
import com.example.parkir.views.core.profile.ProfileView
import com.example.parkir.views.core.profile.SecurityView
import com.example.parkir.views.core.profile.ThemesSettingsView
import com.example.parkir.views.on_boarding.views.OnBoardingView

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Router.OnBoardingScreen.route) {
        composable(route = Router.OnBoardingScreen.route) {
            OnBoardingView(navController = navController)
        }
        composable(route = Router.AuthScreen.route) {
            AuthView(navController = navController)
        }
        composable(route = Router.RegisterScreen.route) {
            RegisterView(navController = navController)
        }
        composable(route = Router.LoginScreen.route) {
            LoginView(navController = navController)
        }
        composable(route = Router.ForgotPasswordScreen.route) {
            ForgotPasswordView(navController = navController)
        }
        composable(route = Router.OTPScreen.route) {
            OTPScreen(navController = navController)
        }
        composable(route = Router.ResetPasswordScreen.route) {
            ResetPasswordView(navController = navController)
        }
        composable(route = Router.ParkirNavScreen.route) {
            ParkirNavView(navController = navController)
        }
        composable(route = Router.HomeScreen.route) {
            HomeView(navController = navController)
        }
        composable(route = Router.BookmarksScreen.route) {
            BookmarksView(navController = navController)
        }
        composable(route = Router.ParkingsScreen.route) {
            ParkingsView(navController = navController)
        }
        composable(route = Router.BookingsScreen.route) {
            BookingsView(navController = navController)
        }
        composable(route = Router.BookingTicketScreen.route) {
            BookingTicketView(navController = navController)
        }
        composable(route = Router.ProfileScreen.route) {
            ProfileView(navController = navController)
        }
        composable(route = Router.EditProfileScreen.route) {
            EditProfileView(navController = navController)
        }
        composable(route = Router.SecurityScreen.route) {
            SecurityView(navController = navController)
        }
        composable(route = Router.NotificationsSettingsScreen.route) {
            NotificationsSettingsView(navController = navController)
        }
        composable(route = Router.ThemesSettingsScreen.route) {
            ThemesSettingsView(navController = navController)
        }
        composable(route = Router.NotificationsScreen.route) {
            NotificationsView(navController = navController)
        }
        composable(route = Router.ParkingsBrowserScreen.route) {
            ParkingsBrowserView(navController = navController)
        }
        composable(route = Router.ParkingDetailsScreen.route) {
            ParkingDetailsView(navController = navController)
        }
        composable(route = Router.ParkingBookingDetailsScreen.route) {
            ParkingBookingDetailsScreen(navController = navController)
        }
        composable(route = Router.PaymentMethodsScreen.route) {
            PaymentMethodsView(navController = navController)
        }
        composable(route = Router.NewCardScreen.route) {
            NewCardView(navController = navController)
        }
        composable(route = Router.SummaryReviewScreen.route) {
            ReviewSummaryView(navController = navController)
        }
    }
}