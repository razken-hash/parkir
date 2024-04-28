package com.example.parkir.views.core.payment

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.core.payment.composables.SummaryItem
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.BackUpBar
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.theme.grey02
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.white

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReviewSummaryView(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grey02)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        BackUpBar(title = "Summary Review", navController = navController)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(white, shape = RoundedCornerShape(15.dp))
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            SummaryItem(title = "Parking Area", value = "Parking Lot of San Manolia")
            SummaryItem(title = "Address", value = "9569, Trantow Courts")
            SummaryItem(title = "Parking Spot", value = "1st Floor (A05)")
            SummaryItem(title = "Date", value = "Dec. 16, 2023")
            SummaryItem(title = "Time", value = "09:00 AM - 01:00 PM")
            SummaryItem(title = "Duration", value = "Parking Lot of San Manolia")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(white, shape = RoundedCornerShape(15.dp))
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            SummaryItem(title = "Ammount", value = "$8")
            SummaryItem(title = "Taxes & Fees", value = "$0.8")
            Divider()
            SummaryItem(title = "Total", value = "$8.8")

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(white, shape = RoundedCornerShape(15.dp))
                .padding(15.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.eddahabia_card),
                contentDescription = "EDDAHABIA Card",
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = "•••• •••• •••• 4679",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f)
            )
            ParkirButton(
                label = "Change",
                labelColor = primary,
                bgColor = white,
                borderColor = white,
                modifier = Modifier.width(100.dp),
                onClick = {
                    navController.navigate(Router.NewCardScreen.route)
                },
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Divider()

        ParkirButton(
            label = "Confirm Payment",
            onClick = {
            },
        )
    }
}


