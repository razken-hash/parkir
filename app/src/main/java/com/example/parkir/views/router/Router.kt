package com.example.parkir.views.router

sealed class Router(val route: String) {
    object OnBoardingScreen: Router("/on_boarding")
    object AuthScreen: Router("/auth")
    object RegisterScreen: Router("/auth/register")
    object LoginScreen: Router("/auth/login")
    object ForgotPasswordScreen: Router("/auth/forgot_password")
    object OTPScreen: Router("/auth/otp")

    object ResetPasswordScreen: Router("/auth/reset_password")
    object ParkirNavScreen: Router("/nav")
    object HomeScreen: Router("/home")
    object ParkingsScreen: Router("/parkings")
    object ParkingDetailsScreen: Router("/parkings/details")
    object ParkingsBrowserScreen: Router("/parkings/browser")
    object ParkingBookingDetailsScreen: Router("/parkings/booking")

    object BookingsScreen: Router("/bookings")
    object ProfileScreen: Router("/profile")
    object EditProfileScreen: Router("/profile/edit")
    object SecurityScreen: Router("/profile/security")
    object NotificationsSettingsScreen: Router("/profile/notifications")
    object ThemesSettingsScreen: Router("/profile/theme")
    object NotificationsScreen: Router("/notifications")
}