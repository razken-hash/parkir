package com.example.parkir.views.core.profile

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.router.Router
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.composables.ParkirField
import com.example.parkir.views.ui.composables.ParkirSwitch
import com.example.parkir.views.ui.theme.black
import com.example.parkir.views.ui.theme.blue
import com.example.parkir.views.ui.theme.green
import com.example.parkir.views.ui.theme.grey02
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.primary1A
import com.example.parkir.views.ui.theme.red
import com.example.parkir.views.ui.theme.white
import com.example.parkir.views.ui.theme.yellow
import kotlinx.coroutines.processNextEventInCurrentThread

@Composable
fun SecurityView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(painter = painterResource(id = R.drawable.arrow_left_outline),
                contentDescription = "Go Back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            Text(
                text = "Security",
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center,
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = "Face ID", style = MaterialTheme.typography.headlineMedium)

                var faceID by remember { mutableStateOf(false) } // State variable to track switch state

                ParkirSwitch(value = faceID, onCheckChange = { faceID = it })

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = "Touch ID", style = MaterialTheme.typography.headlineMedium)

                var touchID by remember { mutableStateOf(false) } // State variable to track switch state

                ParkirSwitch(
                    value = touchID,
                    onCheckChange = {
                        touchID = it
                    },
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = "Remember Me", style = MaterialTheme.typography.headlineMedium)

                var rememberMe by remember { mutableStateOf(false) } // State variable to track switch state

                ParkirSwitch(
                    value = rememberMe,
                    onCheckChange = { rememberMe = it },
                )
            }
        }

        ParkirButton(
            label = "Change Password",
            onClick = {
                navController.popBackStack()
            },
            bgColor = primary1A,
            labelColor = primary,
        )
    }
}

