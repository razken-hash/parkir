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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.BackUpBar
import com.example.parkir.views.ui.composables.ExpandableText
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.primary1A
import com.example.parkir.views.ui.theme.white

@Composable
fun ParkingDetailsView(navController: NavHostController) {

    var vScrollState: ScrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(vScrollState),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        BackUpBar(title = "Parking Details", navController = navController)
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
                Text(text = "2 km", color = primary, style = MaterialTheme.typography.titleMedium)
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
                    text = "8 AM - 10 PM",
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

                Text(text = "Valet", color = primary, style = MaterialTheme.typography.titleMedium)
            }
        }
        Text(
            text = "Description",
            style = MaterialTheme.typography.titleLarge,
        )

        val description =
            "Ut non eu ullamco ullamco voluptate est officia ut quis amet deserunt commodo eu excepteur. Sit laboris in culpa ut. Lorem ut nulla occaecat ullamco laborum. Enim deserunt sint ut elit tempor labore in consectetur nulla dolor. Deserunt do nostrud do deserunt sit aliqua anim elit. Nulla officia ipsum aute aliquip aute anim ipsum sint quis esse sit esse consequat dolor. Minim magna veniam aliqua minim reprehenderit."

        ExpandableText(
            shrinkedText = description.substring(0..120),
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
            Text(text = "$2.00", color = primary, style = MaterialTheme.typography.headlineLarge)
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
