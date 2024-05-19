package com.example.parkir.views.core.parkings.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.Coil
import coil.compose.AsyncImage
import com.example.parkir.R
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.BackUpBar
import com.example.parkir.views.ui.composables.ExpandableText
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.primary1A
import com.example.parkir.views.ui.theme.white
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.logging.Logger

@Composable
fun ParkingDetailsView(
    navController: NavHostController, parkingsViewModel: ParkingsViewModel, parkingId: Int
) {

    var vScrollState: ScrollState = rememberScrollState()
    val logger: Logger = Logger.getLogger("naving")
    logger.info("id $parkingId")

    LaunchedEffect(key1 = 1) {
        CoroutineScope(Dispatchers.IO).launch {
            parkingsViewModel.getParkingById(parkingId = parkingId)
        }
    }





//
    parkingsViewModel.selectedParking?.let {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(vScrollState),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            BackUpBar(title = "Parking Details", navController = navController)
            AsyncImage(
                model = it.image, contentDescription = "Parking Image", modifier =
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
                        text = it.name,
                        style = MaterialTheme.typography.titleLarge,
                    )
                    Text(text = "${it.address.street}, ${it.address.city}")
                }
                Image(
                    painter = painterResource(id = R.drawable.bookmark_bold),
                    contentDescription = "Parking Bookmark",
                    colorFilter = ColorFilter.tint(primary),
                    modifier = Modifier.size(35.dp),
                )
            }

            var scrollState = rememberScrollState()

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.horizontalScroll(scrollState)
            ) {

                Row(
                    Modifier
                        .background(white, shape = RoundedCornerShape(50))
                        .border(2.dp, primary, RoundedCornerShape(50))
                        .padding(10.dp, 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.location_bold),
                        contentDescription = "Location Distance",
                        colorFilter = ColorFilter.tint(primary),
                        modifier = Modifier.size(20.dp),
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "2 km",
                        color = primary,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Row(
                    Modifier
                        .background(white, shape = RoundedCornerShape(50))
                        .border(2.dp, primary, RoundedCornerShape(50))
                        .padding(10.dp, 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.clock_bold),
                        contentDescription = "Clock",
                        colorFilter = ColorFilter.tint(primary),
                        modifier = Modifier.size(20.dp),
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "${it.openingTime.substring(0, 5)} AM - ${it.closingTime.substring(0, 5)} PM",
                        color = primary,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Row(
                    Modifier
                        .background(white, shape = RoundedCornerShape(50))
                        .border(2.dp, primary, RoundedCornerShape(50))
                        .padding(10.dp, 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Text(
                        text = "Valet",
                        color = primary,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
            Text(
                text = "Description",
                style = MaterialTheme.typography.titleLarge,
            )

            val description = it.description

            ExpandableText(
                shrinkedText = description.substring(0..description.length / 2),
                expandedText = description,
                textStyle = MaterialTheme.typography.bodyLarge,
            )

            Spacer(modifier = Modifier.weight(1f))

            Column(
                modifier = Modifier
                    .height(65.dp)
                    .fillMaxWidth()
                    .background(primary1A, shape = RoundedCornerShape(15.dp)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "$${it.pricePerHour}",
                    color = primary,
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(text = "per hour", color = grey, style = MaterialTheme.typography.bodySmall)
            }

            Divider()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                ParkirButton(
                    label = "Cancel",
                    onClick = {
                        navController.popBackStack()
                    },
                    labelColor = primary,
                    bgColor = primary1A,
                    borderColor = primary1A,
                    modifier = Modifier
                        .height(50.dp)
                        .weight(1f),
                )

                ParkirButton(
                    label = "Book Parking",
                    onClick = {
                        navController.navigate(Router.ParkingBookingDetailsScreen.route)
                    },
                    modifier = Modifier
                        .height(50.dp)
                        .weight(1f),
                )
            }
        }

    }
}