package com.example.parkir.views.auth.views.composables


import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.parkir.R
import com.example.parkir.views.ui.theme.black
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.grey06
import com.example.parkir.views.ui.theme.grey13
import com.example.parkir.views.ui.theme.white

@Composable
fun OAuthSection(viewMode: Int) {
    if (viewMode == 0) Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        OAuthTextButton(icon = R.drawable.facebook, title = "Facebook") {

        }
        OAuthTextButton(icon = R.drawable.google, title = "Google") {

        }
        OAuthTextButton(icon = R.drawable.apple, title = "Apple") {

        }
    }
    else Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        OAuthIconButton(icon = R.drawable.facebook, title = "Facebook") {

        }

        Spacer(modifier = Modifier.width(15.dp))

        OAuthIconButton(icon = R.drawable.google, title = "Google") {

        }

        Spacer(modifier = Modifier.width(15.dp))

        OAuthIconButton(icon = R.drawable.apple, title = "Apple") {

        }
    }
}

@Composable
fun OAuthIconButton(
    icon: Int,
    title: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(height = 58.dp, width = 90.dp),
        border = BorderStroke(2.dp, grey13),
        shape = RoundedCornerShape(size = 15.dp),
        colors = ButtonDefaults.buttonColors(containerColor = white, contentColor = black)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = title,
            modifier = Modifier.size(20.dp),
        )
    }
}

@Composable
fun OAuthTextButton(
    icon: Int,
    title: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 58.dp),
        border = BorderStroke(2.dp, grey13),
        shape = RoundedCornerShape(size = 15.dp),
        colors = ButtonDefaults.buttonColors(containerColor = white, contentColor = black)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = title,
                modifier = Modifier.size(20.dp),
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "Continue with $title",
                style = MaterialTheme.typography.titleSmall,
            )
        }
    }
}
