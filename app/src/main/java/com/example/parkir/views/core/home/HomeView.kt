package com.example.parkir.views.core.home

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.white
import com.example.parkir.views.ui.utils.GoogleMapStyle
import com.google.android.gms.maps.UiSettings
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker

@Composable
fun HomeView(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(), properties = MapProperties(
                mapStyleOptions = MapStyleOptions(GoogleMapStyle.style),
            ), uiSettings = MapUiSettings(
                zoomControlsEnabled = true,
                zoomGesturesEnabled = true,
            ), cameraPositionState = CameraPositionState(
                position = CameraPosition(
                    LatLng(36.7538, 3.0588), 14F, 1F, 1F
                )
            )
        ) {
            Marker(position = LatLng(36.7538, 3.0588))
            Marker(position = LatLng(36.7, 3.0))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.End,

            ) {
            Image(painter = painterResource(id = R.drawable.loop_outline),
                contentDescription = "Search",
                colorFilter = ColorFilter.tint(primary),
                modifier = Modifier
                    .size(45.dp)
                    .clickable {
                        navController.navigate(Router.ParkingsBrowserView.route)
                    }
                    .background(white, shape = CircleShape)
                    .padding(8.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.notification_outline),
                contentDescription = "Notifications",
                colorFilter = ColorFilter.tint(primary),
                modifier = Modifier
                    .size(45.dp)
                    .background(white, shape = CircleShape)
                    .clickable {
                        navController.navigate(Router.NotificationsScreen.route)
                    }
                    .padding(8.dp),
            )
        }
    }
}