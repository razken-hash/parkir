package com.example.parkir.views.core.parkings.views

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.core.parkings.views.composables.ParkingCard
import com.example.parkir.views.ui.composables.ParkingIcon
import com.example.parkir.views.ui.composables.ParkirField
import com.example.parkir.views.ui.theme.green
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.red
import com.example.parkir.views.ui.theme.white
import com.google.android.gms.maps.model.Circle

@Composable
fun ParkingsView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        var search by remember {
            mutableStateOf("Parkings")
        }

        ParkirField(
            value = search,
            onValueChange = {
                search = it;
            },
            leadingIconId = R.drawable.loop_outline,
            trailingIconId = R.drawable.filter_outline,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = "Results (1274)", style = MaterialTheme.typography.titleMedium)
            Image(
                painter = painterResource(id = R.drawable.swap),
                contentDescription = "Swap Order",
            )
        }

        var vScrollState = rememberScrollState()

        Column (
            modifier = Modifier.fillMaxSize().verticalScroll(vScrollState),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            for (i in 1..20) {
                ParkingCard()
            }
        }
    }
}



