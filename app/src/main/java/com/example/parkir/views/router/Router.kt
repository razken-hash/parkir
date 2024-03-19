package com.example.parkir.views.router

sealed class Router(val route: String) {
    object OnBoardingScreen: Router("/on_boarding")
    object AuthScreen: Router("/auth")
    object RegisterScreen: Router("/auth/register")
    object LoginScreen: Router("/auth/login")
    object HomeScreen: Router("/home")
}