package com.example.parkir.views.core.home

import androidx.activity.viewModels
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import com.example.parkir.ParkirApplication
import com.example.parkir.R
import com.example.parkir.views.core.parkings.data.entity.Parking
import com.example.parkir.views.core.parkings.views.ParkingsViewModel
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavHostController, parkingsViewModel: ParkingsViewModel) {

    LaunchedEffect(key1 = 1) {
        CoroutineScope(Dispatchers.IO).launch {
            parkingsViewModel.getAllParkings()
        }
    }

    var selectedParking: Parking? by remember {
        mutableStateOf(null)
    }


    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        val scope = rememberCoroutineScope()

        var parkingSheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        )

        var showParkingBottomSheet by rememberSaveable {
            mutableStateOf(false)
        }

        if (!parkingsViewModel.isLoading) {
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
                parkingsViewModel.parkings.value.forEach { parking ->
                    Marker(
                        position = LatLng(parking.address.longitude, parking.address.latitude),
                        onClick = {
                            selectedParking = parking
                            showParkingBottomSheet = true
                            return@Marker true
                        },
                    )
                }
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
                        navController.navigate(Router.ParkingsScreen.route)
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

                    AsyncImage(
                        model = selectedParking!!.image, contentDescription = "Parking Image", modifier =
                        Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(10)),
                        placeholder = painterResource(id = R.drawable.parking),
                        contentScale = ContentScale.FillWidth,
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
                                text = "${selectedParking?.name}",
                                style = MaterialTheme.typography.titleLarge,
                            )
                            Text(text = "${selectedParking?.address?.street}, ${selectedParking?.address?.city}")
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
                                scope.launch { parkingSheetState.hide() }.invokeOnCompletion {
                                    showParkingBottomSheet = false
                                }
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
                                    showParkingBottomSheet = false
                                    navController.navigate(
                                        Router.ParkingDetailsScreen.createRoute(
                                            selectedParking!!.id
                                        )
                                    )
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