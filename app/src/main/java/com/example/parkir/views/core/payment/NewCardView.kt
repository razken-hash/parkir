package com.example.parkir.views.core.payment

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.ui.composables.BackUpBar
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.composables.ParkirField
import com.example.parkir.views.ui.theme.grey02
import com.example.parkir.views.ui.theme.grey13
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.primary1A
import com.example.parkir.views.ui.theme.white

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewCardView(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grey02)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        BackUpBar(title = "New Card", navController = navController)

        Text(text = "Add New Card", style = MaterialTheme.typography.titleLarge)

        var cardBank by remember {
            mutableStateOf("")
        }
        var cardHolderName by remember {
            mutableStateOf("")
        }
        var cardNumber by remember {
            mutableStateOf("")
        }
        var cardDate by remember {
            mutableStateOf("")
        }
        var cardCVC by remember {
            mutableStateOf("")
        }

        Image(
            painter = painterResource(id = R.drawable.eddahabia_card),
            contentDescription = "EDDAHABIA Card",
            modifier = Modifier.fillMaxWidth(),
        )

        ParkirField(
            value = cardBank,
            onValueChange = {
                cardBank = it
            },
            leadingIconId = R.drawable.shield_tick_outline,
            placeHolderText = "Bank Name"
        )

        ParkirField(
            value = cardHolderName,
            onValueChange = {
                cardHolderName = it
            },
            leadingIconId = R.drawable.profile_outline,
            placeHolderText = "Card Holder Name"
        )

        ParkirField(
            value = cardNumber,
            onValueChange = {
                cardNumber = it
            },
            placeHolderText = "Card Number",
            leadingIconId = R.drawable.wallet_outline,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            ParkirField(
                value = cardDate,
                onValueChange = {
                    cardDate = it
                },
                modifier = Modifier.weight(1f),
                leadingIconId = R.drawable.calendar,
                placeHolderText = "09/25"
            )
            ParkirField(
                value = cardCVC,
                onValueChange = {
                    cardCVC = it
                },
                modifier = Modifier.weight(1f),
                leadingIconId = R.drawable.doc_outline,
                placeHolderText = "CVC",
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Divider()

        ParkirButton(
            label = "Add New Card",
            onClick = {
                navController.popBackStack()
            },
        )
    }
}
