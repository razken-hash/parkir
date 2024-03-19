package com.example.parkir.views.router

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.parkir.views.auth.views.AuthView
import com.example.parkir.views.auth.views.LoginView
import com.example.parkir.views.auth.views.RegisterView
import com.example.parkir.views.core.home.HomeView
import com.example.parkir.views.on_boarding.views.OnBoardingView

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Router.OnBoardingScreen.route) {
        composable(route = Router.OnBoardingScreen.route) {
            OnBoardingView(navController = navController)
        }
        composable(route = Router.AuthScreen.route) {
            AuthView(navController = navController)
        }
        composable(route = Router.LoginScreen.route) {
            LoginView(navController = navController)
        }
        composable(route = Router.RegisterScreen.route) {
            RegisterView(navController = navController)
        }
        composable(route = Router.HomeScreen.route) {
            HomeView(navController = navController)
        }
    }
}