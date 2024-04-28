package com.example.parkir.views.core.payment

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.theme.grey02
import com.example.parkir.views.ui.theme.grey13
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.primary1A
import com.example.parkir.views.ui.theme.white

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PaymentMethodsView(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grey02)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        BackUpBar(title = "Payment", navController = navController)
        Text(text = "Choose your payment method", style = MaterialTheme.typography.titleLarge)

        var selectedWay by remember {
            mutableStateOf(1)
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = if (selectedWay == 1) 2.dp else 0.dp,
                    color = if (selectedWay == 1) primary else grey13,
                    shape = RoundedCornerShape(size = 15.dp)
                )
                .background(white, RoundedCornerShape(size = 15.dp))
                .clickable {
                    selectedWay = 1
                }
                .padding(15.dp)) {
            Image(
                painter = painterResource(id = R.drawable.dinar),
                contentDescription = "200 Dinar",
                modifier = Modifier.size(32.dp)
            )

            Text(
                text = "Cash", style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f),
            )

            RadioButton(
                selected = selectedWay == 1, onClick = { selectedWay = 1 },
                colors = RadioButtonDefaults.colors(
                    selectedColor = primary, unselectedColor = primary
                ),
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = if (selectedWay == 2) 2.dp else 0.dp,
                    color = if (selectedWay == 2) primary else grey13,
                    shape = RoundedCornerShape(size = 15.dp)
                )
                .background(white, RoundedCornerShape(size = 15.dp))
                .clickable {
                    selectedWay = 2
                }
                .padding(15.dp)) {
            Image(
                painter = painterResource(id = R.drawable.baridi_mob),
                contentDescription = "BaridiMob",
                modifier = Modifier.size(32.dp)
            )

            Text(
                text = "BaridiMob", style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f),
            )

            RadioButton(
                selected = selectedWay == 2, onClick = { selectedWay = 2 },
                colors = RadioButtonDefaults.colors(
                    selectedColor = primary, unselectedColor = primary
                ),
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = if (selectedWay == 3) 2.dp else 0.dp,
                    color = if (selectedWay == 3) primary else grey13,
                    shape = RoundedCornerShape(size = 15.dp)
                )
                .background(white, RoundedCornerShape(size = 15.dp))
                .clickable {
                    selectedWay = 3
                }
                .padding(15.dp)) {
            Image(
                painter = painterResource(id = R.drawable.eddahabia_card),
                contentDescription = "EDDAHABIA Card",
                modifier = Modifier.size(32.dp)
            )

            Text(
                text = "EDDAHABIA Card",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f),
            )

            RadioButton(
                selected = selectedWay == 3, onClick = { selectedWay = 3 },
                colors = RadioButtonDefaults.colors(
                    selectedColor = primary, unselectedColor = primary
                ),
            )
        }

        ParkirButton(
            label = "Add New Card",
            labelColor = primary,
            bgColor = primary1A,
            borderColor = primary1A,
            onClick = {
                navController.navigate(Router.NewCardScreen.route)
            },
        )

        Spacer(modifier = Modifier.weight(1f))

        Divider()

        ParkirButton(label = "Continue", onClick = {
            navController.navigate(Router.SummaryReviewScreen.route)
        })
    }
}
