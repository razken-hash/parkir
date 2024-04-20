package com.example.parkir.views.core.notifications

import android.content.pm.LauncherApps
import android.widget.Space
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.core.notifications.composables.NotificationCard
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.BackUpBar
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.composables.shapes.BublleShape
import com.example.parkir.views.ui.theme.black
import com.example.parkir.views.ui.theme.green
import com.example.parkir.views.ui.theme.grey02
import com.example.parkir.views.ui.theme.grey06
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.primary1A
import com.example.parkir.views.ui.theme.purple
import com.example.parkir.views.ui.theme.red
import com.example.parkir.views.ui.theme.turquoise
import com.example.parkir.views.ui.theme.white
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.coroutineScope as coroutineScope1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grey02)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            BackUpBar(title = "Notifications", navController = navController)

            Image(
                painter = painterResource(id = R.drawable.dots_circle_outline),
                contentDescription = "Dots",
                modifier = Modifier.size(35.dp),
            )
        }

        val vScrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .verticalScroll(vScrollState),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            Text(text = "Today", style = MaterialTheme.typography.titleLarge)

            NotificationCard(
                title = "Payment Successful!",
                subTitle = "Parking booking at Portley was successful",
                icon = R.drawable.tick_square_bold,
                color = green
            )
            NotificationCard(
                title = "Parking Booking Canceled",
                subTitle = "Parking booking at Gousel has been canceled successfully",
                icon = R.drawable.close_square_bold,
                color = red
            )

            Text(text = "Yesterday", style = MaterialTheme.typography.titleLarge)

            NotificationCard(
                title = "2 Steps Verification Successful!",
                subTitle = "Google Authenticator was successful",
                icon = R.drawable.lock_bold,
                color = primary
            )

            Text(text = "December 11, 2024", style = MaterialTheme.typography.titleLarge)

            NotificationCard(
                title = "E-Wallet Connected",
                subTitle = "Wallet has been connected successfully",
                icon = R.drawable.wallet_bold,
                color = turquoise
            )
            NotificationCard(
                title = "Verification Successful!",
                subTitle = "Account verification completed",
                icon = R.drawable.tick_square_bold,
                color = green
            )

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}


