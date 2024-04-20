package com.example.parkir.views.core.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.theme.black
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.primary1A
import com.example.parkir.views.ui.theme.red
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.parkir),
                    contentDescription = "Parkir",
                    modifier = Modifier.size(35.dp),
                )
                Text(
                    text = "Profile", style = MaterialTheme.typography.displaySmall,
                )
            }
            Image(
                painter = painterResource(id = R.drawable.dots_circle_outline),
                contentDescription = "Dots",
                modifier = Modifier.size(35.dp),
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_pic),
                contentDescription = "Parkir",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
            )
            Text(text = "KENNICHE ABDERRAZAK", style = MaterialTheme.typography.titleMedium)
            Text(text = "ka_kenniche@esi.dz", style = MaterialTheme.typography.labelLarge)
        }

        Divider(
            modifier = Modifier
                .padding(
                    20.dp,
                ),
        )


        val scope = rememberCoroutineScope()

        var logoutSheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        )

        var showLogoutBottomSheet by rememberSaveable {
            mutableStateOf(false)
        }

        Column {
            ProfileItem(title = "Edit Profile", icon = R.drawable.profile_outline) {
                navController.navigate(Router.EditProfileScreen.route)
            }
            ProfileItem(title = "Payment", icon = R.drawable.wallet_outline) {

            }
            ProfileItem(title = "Security", icon = R.drawable.shield_tick_outline) {
                navController.navigate(Router.SecurityScreen.route)
            }
            ProfileItem(title = "Notifications", icon = R.drawable.notification_outline) {
                navController.navigate(Router.NotificationsSettingsScreen.route)
            }
            ProfileItem(title = "Themes", icon = R.drawable.show_outline) {
                navController.navigate(Router.ThemesSettingsScreen.route)
            }
            ProfileItem(title = "Help", icon = R.drawable.info_square_outline) {

            }
            ProfileItem(title = "Logout", icon = R.drawable.logout_outline, color = red) {
                showLogoutBottomSheet = true
            }
        }


        if (showLogoutBottomSheet)
            ModalBottomSheet(
                sheetState = logoutSheetState,
                onDismissRequest = {
                    scope.launch { logoutSheetState.hide() }.invokeOnCompletion {
                        if (!logoutSheetState.isVisible) {
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
                        style = MaterialTheme.typography.titleMedium,
                    )

                    ParkirButton(
                        label = "Logout",
                        onClick = {
                            showLogoutBottomSheet = false
                            navController.popBackStack()
                            navController.navigate(Router.AuthScreen.route)
                        },
                    )
                    ParkirButton(
                        label = "Cancel",
                        onClick = {
                            scope.launch { logoutSheetState.hide() }.invokeOnCompletion {
                                if (!logoutSheetState.isVisible) {
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
}


@Composable
fun ProfileItem(
    title: String,
    icon: Int,
    color: Color = black,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 20.dp,
                vertical = 10.dp,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = title,
            colorFilter = ColorFilter.tint(color),
            modifier = Modifier.size(35.dp),
        )
        Text(text = title, style = MaterialTheme.typography.headlineMedium, color = color)
    }
}