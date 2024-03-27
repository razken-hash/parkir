package com.example.parkir.views.core.parkings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.ui.composables.ParkirField
import com.example.parkir.views.ui.theme.black
import com.example.parkir.views.ui.theme.grey6F
import com.example.parkir.views.ui.theme.primary

@Composable
fun ParkingsBrowserView(navController: NavHostController) {
    var search by remember {
        mutableStateOf("")
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
}