package com.example.parkir.views.core.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parkir.views.core.bookings.BookingsView
import com.example.parkir.views.core.home.HomeView
import com.example.parkir.views.core.navigation.composables.NavItemBox
import com.example.parkir.views.core.navigation.model.NavItem
import com.example.parkir.views.core.bookmarks.views.BookmarksView
import com.example.parkir.views.core.parkings.views.ParkingsViewModel
import com.example.parkir.views.core.profile.ProfileView
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParkirNavView(navController: NavHostController, parkingsViewModel: ParkingsViewModel) {


    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    val navBarController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = white,

                ) {
                NavItem.navItems.forEach { item ->
                    NavItemBox(
                        item = item,
                        isSelected = selectedItem == item.id,
                        onClick = {
                            selectedItem = item.id
                            navBarController.navigate(item.destination)
                        },
                    )
                }
            }
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),

                ) {

                NavHost(
                    navController = navBarController, startDestination = Router.HomeScreen.route,
                )
                {
                    composable(route = Router.HomeScreen.route) {
                        HomeView(navController = navController, parkingsViewModel = parkingsViewModel)
                    }
                    composable(route = Router.BookmarksScreen.route) {
                        BookmarksView(navController = navController)
                    }
                    composable(route = Router.BookingsScreen.route) {
                        BookingsView(navController = navController)
                    }
                    composable(route = Router.ProfileScreen.route) {
                        ProfileView(navController = navController)
                    }
                }
            }
        }
    )
}