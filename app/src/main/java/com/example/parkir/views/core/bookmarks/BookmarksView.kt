package com.example.parkir.views.core.bookmarks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.core.bookings.composables.BookingCard
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.composables.ParkirField
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.grey02
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.primary1A
import com.example.parkir.views.ui.theme.red
import com.example.parkir.views.ui.theme.white
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookmarksView(navController: NavHostController) {

    val scope = rememberCoroutineScope()

    var cancelBookmarkSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    var showCancelBookmarkSheet by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grey02)
            .padding(20.dp, 20.dp, 20.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
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
                    text = "My Bookmarks", style = MaterialTheme.typography.displaySmall,
                )
            }
            Image(
                painter = painterResource(id = R.drawable.dots_circle_outline),
                contentDescription = "Dots",
                modifier = Modifier.size(35.dp),
            )
        }

        var search by remember {
            mutableStateOf("")
        }

        ParkirField(
            value = search,
            onValueChange = {
                search = it;
            },
            leadingIconId = R.drawable.loop_outline,
            trailingIconId = R.drawable.filter_outline,
        )

        val vScrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(vScrollState),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            for (i in 1..10) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            white,
                            shape = RoundedCornerShape(20.dp),
                        )
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.parking),
                        contentDescription = "Parking Picture",
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(size = 10.dp)),
                        contentScale = ContentScale.FillBounds,
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Column(
                        modifier = Modifier.height(60.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                    ) {
                        Text(
                            text = "Welbeck North",
                            style = MaterialTheme.typography.headlineLarge,
                        )
                        Text(text = "7159 Washington Alley")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.bookmark_bold),
                        contentDescription = "Parking Bookmark",
                        colorFilter = ColorFilter.tint(primary),
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                showCancelBookmarkSheet = true
                            },
                    )
                }
            }
            Spacer(modifier = Modifier.height(0.dp))
        }
    }
    if (showCancelBookmarkSheet) {
        ModalBottomSheet(
            sheetState = cancelBookmarkSheetState,
            onDismissRequest = {
                scope.launch { cancelBookmarkSheetState.hide() }.invokeOnCompletion {
                    if (!cancelBookmarkSheetState.isVisible) {
                        showCancelBookmarkSheet = false
                    }
                }
            },
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(
                    start = 20.dp, top = 0.dp, end = 20.dp, bottom = 30.dp
                )
            ) {
                Text(
                    text = "Remove from Bookmarks?", style = MaterialTheme.typography.titleLarge
                )

                Divider()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            white,
                            shape = RoundedCornerShape(20.dp),
                        )
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.parking),
                        contentDescription = "Parking Picture",
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(size = 10.dp)),
                        contentScale = ContentScale.FillBounds,
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Column(
                        modifier = Modifier.height(60.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                    ) {
                        Text(
                            text = "Welbeck North",
                            style = MaterialTheme.typography.headlineLarge,
                        )
                        Text(text = "7159 Washington Alley")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.bookmark_bold),
                        contentDescription = "Parking Bookmark",
                        colorFilter = ColorFilter.tint(primary),
                        modifier = Modifier.size(30.dp),
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    ParkirButton(
                        label = "Cancel",
                        onClick = {
                            scope.launch { cancelBookmarkSheetState.hide() }.invokeOnCompletion {
                                if (!cancelBookmarkSheetState.isVisible) {
                                    showCancelBookmarkSheet = false
                                }
                            }
                        },
                        modifier = Modifier
                            .height(55.dp)
                            .weight(1f),
                        labelColor = primary,
                        bgColor = primary1A,
                        borderColor = primary1A,
                    )

                    ParkirButton(
                        label = "Yes, Remove",
                        onClick = {
                            showCancelBookmarkSheet = false
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

