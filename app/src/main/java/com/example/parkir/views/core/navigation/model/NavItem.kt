package com.example.parkir.views.core.navigation.model

import android.media.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.parkir.R
import com.example.parkir.views.on_boarding.model.OnBoardingItem
import com.example.parkir.views.router.Router

sealed class NavItem(
    val id: Int,
    val title: String,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val destination: String,
) {
    object Home :
        NavItem(
            1,
            "Home",
            selectedIcon = R.drawable.home_bold,
            unselectedIcon = R.drawable.home_outline,
            destination = Router.HomeScreen.route,
        )

    object Parkings :
        NavItem(
            2,
            "Parkings",
            selectedIcon = R.drawable.bookmark_bold,
            unselectedIcon =R.drawable.bookmark_outline,
            destination = Router.ParkingsScreen.route,
        )

    object Bookings :
        NavItem(
            3,
            "Bookings",
            selectedIcon = R.drawable.doc_bold,
            unselectedIcon = R.drawable.doc_outline,
            destination = Router.BookingsScreen.route,
        )
    object Profile :
        NavItem(
            4,
            "Profile",
            selectedIcon = R.drawable.profile_bold,
            unselectedIcon = R.drawable.profile_outline,
            destination = Router.ProfileScreen.route,
        )

    companion object {
        val navItems: List<NavItem> = listOf(
           Home, Parkings, Bookings, Profile
        )
    }

}