package com.example.parkir.views.core.parkings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.composables.ParkirField
import com.example.parkir.views.ui.theme.black
import com.example.parkir.views.ui.theme.grey6F
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.primary1A
import com.example.parkir.views.ui.theme.red
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParkingsBrowserView(navController: NavHostController) {
    var search by remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    var bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    var showLogoutBottomSheet by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
    ) {
        ParkirField(
            value = search,
            onValueChange = {
                search = it;
            },
            leadingIconId = R.drawable.loop_outline,
            trailingIconId = R.drawable.filter_outline,
        )
    }

    if (showLogoutBottomSheet)
        ModalBottomSheet(
            sheetState = bottomSheetState,
            onDismissRequest = {
                scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                    if (!bottomSheetState.isVisible) {
                        showLogoutBottomSheet = false
                    }
                }
            },
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(
                    start = 20.dp,
                    top = 0.dp,
                    end = 20.dp,
                    bottom = 30.dp
                )
            ) {
                Text(
                    text = "Logout",
                    color = red,
                    style = MaterialTheme.typography.titleLarge
                )
                Divider()
                Text(
                    text = "Are you sure you want to logout?",
                    style = MaterialTheme.typography.bodyLarge,
                )

                ParkirButton(label = "Logout", onClick = {
                    showLogoutBottomSheet = false
                    navController.popBackStack()
                    navController.navigate(Router.AuthScreen.route)
                })
                ParkirButton(
                    label = "Cancel",
                    onClick = {
                        scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                            if (!bottomSheetState.isVisible) {
                                showLogoutBottomSheet = false
                            }
                        }
                    },
                    bgColor = primary1A,
                    labelColor = primary,
                )
            }

        }
}