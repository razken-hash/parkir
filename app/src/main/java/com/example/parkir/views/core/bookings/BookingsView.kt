package com.example.parkir.views.core.bookings

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.core.bookings.composables.BookingCard
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.theme.green
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.grey02
import com.example.parkir.views.ui.theme.lightGreen
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.primary1A
import com.example.parkir.views.ui.theme.red
import com.example.parkir.views.ui.theme.white
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingsView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grey02),
        horizontalAlignment = Alignment.CenterHorizontally,
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
            ) {
                Image(
                    painter = painterResource(id = R.drawable.parkir),
                    contentDescription = "Parkir",
                    modifier = Modifier.size(35.dp),
                )
                Text(
                    text = "My Bookings", style = MaterialTheme.typography.displaySmall,
                )
            }
            Image(
                painter = painterResource(id = R.drawable.loop_outline),
                contentDescription = "loop",
                modifier = Modifier.size(25.dp),
            )
        }

        val scrollState = rememberScrollState()


        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            ParkirButton(
                label = "On going",
                onClick = {},
                bgColor = white,
                labelColor = primary,
                borderColor = primary,
                modifier = Modifier
                    .width(140.dp)
                    .height(45.dp),
            )
            ParkirButton(
                label = "Completed", onClick = {},
                modifier = Modifier
                    .width(140.dp)
                    .height(45.dp),

                )
            ParkirButton(
                label = "Canceled", onClick = {}, bgColor = white, labelColor = primary,
                borderColor = primary,

                modifier = Modifier
                    .width(140.dp)
                    .height(45.dp),

                )
        }

        val bookingsScrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(bookingsScrollState)
        ) {
            for (i in 1..10) {
                BookingCard()
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

