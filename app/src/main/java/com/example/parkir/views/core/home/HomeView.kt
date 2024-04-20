package com.example.parkir.views.core.home

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.white
import com.example.parkir.views.ui.utils.GoogleMapStyle
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        val scope = rememberCoroutineScope()

        var parkingSheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        )

        var showParkingBottomSheet by rememberSaveable {
            mutableStateOf(false)
        }

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
            Marker(
                position = LatLng(36.7538, 3.0588),
                onClick = {
                    showParkingBottomSheet = true
                    print("Helloo")
                    return@Marker true
                },
            )
            Marker(position = LatLng(36.7, 3.0)) {
                showParkingBottomSheet = true
            }
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
                        navController.navigate(Router.ParkingDetailsScreen.route)
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

        if (showParkingBottomSheet)
            ModalBottomSheet(
                sheetState = parkingSheetState,
                onDismissRequest = {
                    scope.launch { parkingSheetState.hide() }.invokeOnCompletion {
                        if (!parkingSheetState.isVisible) {
                            showParkingBottomSheet = false
                        }
                    }
                },
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(
                        start = 20.dp,
                        top = 0.dp,
                        end = 20.dp,
                        bottom = 30.dp
                    )
                ) {
                    Text(
                        text = "Details",
                        style = MaterialTheme.typography.displaySmall
                    )

                    Divider()

                    Image(
                        painter = painterResource(id = R.drawable.parking),
                        contentDescription = "Parking Screen",
                        modifier = Modifier.clip(shape = RoundedCornerShape(10)),
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(5.dp),
                        ) {
                            Text(
                                text = "Parking Lot of San Manolia",
                                style = MaterialTheme.typography.titleLarge,
                            )
                            Text(text = "9565, Trantow Courts, San Manolia")
                        }
                        Image(
                            painter = painterResource(id = R.drawable.bookmark_outline),
                            contentDescription = "Parking Bookmark",
                            colorFilter = ColorFilter.tint(primary),
                            modifier = Modifier.size(35.dp),
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                    ) {
                        ParkirButton(
                            label = "Cancel",
                            onClick = {
                                showParkingBottomSheet = false
                                navController.popBackStack()
                            },
                            modifier = Modifier
                                .height(55.dp)
                                .weight(1f),
                            labelColor = primary,
                            bgColor = white,
                            borderColor = primary,
                        )

                        ParkirButton(
                            label = "Details",
                            onClick = {
                                scope.launch { parkingSheetState.hide() }.invokeOnCompletion {
                                    if (!parkingSheetState.isVisible) {
                                        showParkingBottomSheet = false
                                    }
                                }
                            },
                            modifier = Modifier
                                .height(55.dp)
                                .weight(1f),
                        )
                    }
                }

            }
    }
}