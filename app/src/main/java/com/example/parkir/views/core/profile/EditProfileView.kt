package com.example.parkir.views.core.profile

import android.os.Build
import android.widget.Space
import androidx.annotation.RequiresApi
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
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
import com.example.parkir.views.ui.composables.ParkirButton
import com.example.parkir.views.ui.composables.ParkirField
import com.example.parkir.views.ui.theme.primary

@Composable
fun EditProfileView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
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
                text = "Edit Profile",
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center,
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.profile_pic),
                    contentDescription = "Parkir",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape),
                )
                Image(
                    painter = painterResource(id = R.drawable.edit_square_bold),
                    contentDescription = "Parkir",
                    colorFilter = ColorFilter.tint(primary),
                    modifier = Modifier
                        .size(35.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = (-2).dp, y = (-2).dp)
                )
            }
            var fullName by remember {
                mutableStateOf("")
            }
            var birthDate by remember {
                mutableStateOf("")
            }
            var email = "ka_kenniche@esi.dz"
            var phoneNumber by remember {
                mutableStateOf("")
            }
            var gender by remember {
                mutableStateOf("")
            }
            ParkirField(
                value = fullName,
                onValueChange = {
                    fullName = it
                },
                placeHolderText = "Full name",
                leadingIconId = R.drawable.profile_outline,
                leadingIconDescription = "Full name"
            )

            ParkirField(
                value = birthDate,
                onValueChange = {},
                readOnly = true,
                placeHolderText = "Date of birth",
                leadingIconId = R.drawable.calendar,
                leadingIconDescription = "Date of birth",
                modifier = Modifier.clickable {}
            )

            ParkirField(
                value = email,
                onValueChange = {},
                placeHolderText = "Email",
                readOnly = true,
                leadingIconId = R.drawable.message_outline,
                leadingIconDescription = "Email",
            )

            ParkirField(
                value = phoneNumber,
                onValueChange = {
                    phoneNumber = it
                },
                placeHolderText = "Phone number",
                leadingIconId = R.drawable.phone,
                leadingIconDescription = "Phone number",
            )

            ParkirField(
                value = gender, onValueChange = {
                    gender = it
                }, placeHolderText = "Gender"
            )

        }

        ParkirButton(
            label = "Update",
            onClick = {
                navController.popBackStack()
            },
        )
    }
}

