package com.example.parkir.views.core.bookings.views

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.core.bookings.data.entity.Booking
import com.example.parkir.views.core.bookings.data.entity.BookingStatus
import com.example.parkir.views.core.bookings.views.composables.BookingCard
import com.example.parkir.views.core.parkings.data.entity.Parking
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingsView(navController: NavHostController, bookingsViewModel: BookingsViewModel) {

    LaunchedEffect(key1 = 1) {
        CoroutineScope(Dispatchers.IO).launch {
            bookingsViewModel.getAllBookings()
        }
    }

    var selectedBooking: Booking? by remember {
        mutableStateOf(null)
    }

    val scope = rememberCoroutineScope()

    var cancelBookingSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    var showCancelBookingSheet by rememberSaveable {
        mutableStateOf(false)
    }

    var selectedCategory: String by remember {
        mutableStateOf("All")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grey02),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 20.dp, 20.dp, 0.dp),
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
                .padding(horizontal = 20.dp)
        ) {
            ParkirButton(
                label = "All",
                onClick = {
                    selectedCategory = "All"
                    CoroutineScope(Dispatchers.IO).launch {
                        bookingsViewModel.getAllBookings()
                    }
                },
                bgColor = if (selectedCategory == "All") primary else white,
                labelColor = if (selectedCategory == "All") white else primary,
                borderColor = primary,
                modifier = Modifier
                    .width(140.dp)
                    .height(45.dp),
            )
            ParkirButton(
                label = "Paid",
                onClick = {
                    selectedCategory = "Paid"
                    CoroutineScope(Dispatchers.IO).launch {
                        bookingsViewModel.getBookingsByStatus(BookingStatus.Paid)
                    }
                },
                bgColor = if (selectedCategory == "Paid") primary else white,
                labelColor = if (selectedCategory == "Paid") white else primary,
                borderColor = primary,
                modifier = Modifier
                    .width(140.dp)
                    .height(45.dp),
            )
            ParkirButton(
                label = "Completed",
                onClick = {
                    selectedCategory = "Completed"
                    CoroutineScope(Dispatchers.IO).launch {
                        bookingsViewModel.getBookingsByStatus(BookingStatus.Completed)
                    }
                },
                bgColor = if (selectedCategory == "Completed") primary else white,
                labelColor = if (selectedCategory == "Completed") white else primary,
                borderColor = primary,
                modifier = Modifier
                    .width(140.dp)
                    .height(45.dp),

                )
            ParkirButton(
                label = "Canceled",
                onClick = {
                    selectedCategory = "Canceled"
                    CoroutineScope(Dispatchers.IO).launch {
                        bookingsViewModel.getBookingsByStatus(BookingStatus.Canceled)
                    }
                },
                bgColor = if (selectedCategory == "Canceled") primary else white,
                labelColor = if (selectedCategory == "Canceled") white else primary,
                borderColor = primary,
                modifier = Modifier
                    .width(140.dp)
                    .height(45.dp),

                )
        }

        val bookingsScrollState = rememberScrollState()
        if (bookingsViewModel.isLoading) {
            Box(
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
        } else {
            bookingsViewModel.bookings?.let { bookings ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)
                        .verticalScroll(bookingsScrollState)
                ) {
                    for (booking in bookings) {
                        BookingCard(navController = navController, booking = booking)
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }

        if (showCancelBookingSheet) {
            ModalBottomSheet(
                sheetState = cancelBookingSheetState,
                onDismissRequest = {
                    scope.launch { cancelBookingSheetState.hide() }.invokeOnCompletion {
                        if (!cancelBookingSheetState.isVisible) {
                            showCancelBookingSheet = false
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
                        text = "Cancel Booking",
                        color = red,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Divider()
                    Text(
                        text = "Are you sure you want to cancel your parking reservation?",
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "Only 80% of the money you can refund from your payment according to our policy",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                    ) {
                        ParkirButton(
                            label = "Cancel",
                            onClick = {
                                scope.launch { cancelBookingSheetState.hide() }.invokeOnCompletion {
                                    if (!cancelBookingSheetState.isVisible) {
                                        showCancelBookingSheet = false
                                    }
                                }
                            },
                            modifier = Modifier
                                .height(50.dp)
                                .weight(1f),
                            labelColor = primary,
                            bgColor = primary1A,
                            borderColor = primary1A,
                        )

                        ParkirButton(
                            label = "Yes, Continue",
                            onClick = {
                                showCancelBookingSheet = false
                                navController.popBackStack()
                                navController.navigate(Router.AuthScreen.route)

                            },
                            modifier = Modifier
                                .height(50.dp)
                                .weight(1f),
                        )
                    }
                }
            }
        }
    }
}

