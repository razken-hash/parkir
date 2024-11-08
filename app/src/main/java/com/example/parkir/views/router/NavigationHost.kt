package com.example.parkir.views.router

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.parkir.views.auth.views.AuthView
import com.example.parkir.views.auth.views.AuthViewModel
import com.example.parkir.views.auth.views.LoginView
import com.example.parkir.views.auth.views.RegisterView
import com.example.parkir.views.auth.views.forgot_password.ForgotPasswordView
import com.example.parkir.views.auth.views.forgot_password.OTPScreen
import com.example.parkir.views.auth.views.forgot_password.ResetPasswordView
import com.example.parkir.views.core.bookings.views.BookingTicketView
import com.example.parkir.views.core.bookings.views.BookingsView
import com.example.parkir.views.core.bookings.views.BookingsViewModel
import com.example.parkir.views.core.home.HomeView
import com.example.parkir.views.core.navigation.ParkirNavView
import com.example.parkir.views.core.notifications.NotificationsView
import com.example.parkir.views.core.bookmarks.views.BookmarksView
import com.example.parkir.views.core.parkings.views.ParkingBookingDetailsScreen
import com.example.parkir.views.core.parkings.views.ParkingDetailsView
import com.example.parkir.views.core.parkings.views.ParkingsBrowserView
import com.example.parkir.views.core.parkings.views.ParkingsView
import com.example.parkir.views.core.parkings.views.ParkingsViewModel
import com.example.parkir.views.core.payment.views.NewCardView
import com.example.parkir.views.core.payment.views.ParkingTimerView
import com.example.parkir.views.core.payment.views.PaymentMethodsView
import com.example.parkir.views.core.payment.views.ReviewSummaryView
import com.example.parkir.views.core.profile.EditProfileView
import com.example.parkir.views.core.profile.NotificationsSettingsView
import com.example.parkir.views.core.profile.ProfileView
import com.example.parkir.views.core.profile.SecurityView
import com.example.parkir.views.core.profile.ThemesSettingsView
import com.example.parkir.views.on_boarding.views.OnBoardingView

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationHost(
    authViewModel: AuthViewModel,
    parkingsViewModel: ParkingsViewModel,
    bookingsViewModel: BookingsViewModel,
    navController: NavHostController,
    pref: SharedPreferences
) {

    val userId = pref.getInt("userId",-1);
    val startScreen = if (userId == -1) Router.OnBoardingScreen.route else Router.ParkirNavScreen.route

    NavHost(navController = navController, startDestination = startScreen) {
        composable(route = Router.OnBoardingScreen.route) {
            OnBoardingView(navController = navController)
        }
        composable(route = Router.AuthScreen.route) {
            AuthView(navController = navController, authViewModel = authViewModel)
        }
        composable(route = Router.RegisterScreen.route) {
            RegisterView(navController = navController, authViewModel = authViewModel)
        }
        composable(route = Router.LoginScreen.route) {
            LoginView(navController = navController, authViewModel = authViewModel)
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
            ParkirNavView(
                navController = navController,
                parkingsViewModel = parkingsViewModel,
                bookingsViewModel = bookingsViewModel
            )
        }
        composable(route = Router.HomeScreen.route) {
            HomeView(navController = navController, parkingsViewModel = parkingsViewModel)
        }

        composable(route = Router.BookmarksScreen.route) {
            BookmarksView(navController = navController)
        }
        composable(route = Router.ParkingsScreen.route) { backStackEntry ->
            ParkingsView(navController = navController)
        }
        composable(route = Router.BookingsScreen.route) {
            BookingsView(
                navController = navController, bookingsViewModel = bookingsViewModel
            )
        }

        composable(route = Router.BookingTicketScreen.route) { backStackEntry ->
            val bookingId: Int = backStackEntry.arguments?.getString("bookingId")?.toInt()!!

            BookingTicketView(
                navController = navController,
                bookingsViewModel = bookingsViewModel,
                bookingId = bookingId
            )
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
        composable(route = Router.ParkingDetailsScreen.route) { backStackEntry ->
            val parkingId: Int = backStackEntry.arguments?.getString("parkingId")?.toInt()!!
            ParkingDetailsView(
                navController = navController,
                parkingsViewModel = parkingsViewModel,
                parkingId = parkingId
            )
        }
        composable(route = Router.ParkingBookingDetailsScreen.route) {
            ParkingBookingDetailsScreen(navController = navController, parkingsViewModel= parkingsViewModel, bookingsViewModel = bookingsViewModel)
        }
        composable(route = Router.PaymentMethodsScreen.route) {
            PaymentMethodsView(navController = navController, bookingsViewModel = bookingsViewModel)
        }
        composable(route = Router.NewCardScreen.route) {
            NewCardView(navController = navController)
        }
        composable(route = Router.SummaryReviewScreen.route) {
            ReviewSummaryView(navController = navController, bookingsViewModel = bookingsViewModel)
        }
        composable(route = Router.ParkingTimerScreen.route) {
            ParkingTimerView(navController = navController)
        }
    }
}