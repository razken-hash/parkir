package com.example.parkir.views.core.payment.views


import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parkir.views.core.payment.views.composables.SummaryItem
import com.example.parkir.views.ui.composables.BackUpBar
import com.example.parkir.views.ui.theme.grey02
import com.example.parkir.views.ui.theme.white
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.minutes

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ParkingTimerView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grey02)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        BackUpBar(title = "Parking Timer", navController = navController)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(modifier = Modifier.size(300.dp)) {
                CircularTimer(duration = 10.minutes)
            }

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
                SummaryItem(title = "Duration", value = "4 hours")
            }
        }

    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CircularTimer(
    duration: kotlin.time.Duration, modifier: Modifier = Modifier, color: Color = Color.Blue
) {

    var totalTime by remember { mutableStateOf(duration.inWholeSeconds * 1000) }
    var progress by remember { mutableStateOf(0f) }
    var progressTime by remember { mutableStateOf(totalTime) }

    LaunchedEffect(key1 = totalTime) {
        val animation = Animatable(0f)
        launch {
            animation.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = totalTime.toInt(), easing = LinearEasing)
            )
        }
        for (i in 0..totalTime) {
            delay(100)
            progress = animation.value
            progressTime = progressTime - 1
            Log.d("TimeKENNICHE", "$progressTime")
        }
    }

    Surface(modifier = modifier.background(Color.Transparent)) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(Color.Transparent)
        ) {
            val diameter = size.minDimension
            val strokeWidth = diameter * 0.06f
            val startAngle = 270f
            val sweep = 360 * progress

            drawArc(
                color = color,
                startAngle = startAngle,
                sweepAngle = sweep,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )
        }
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Text(
//                text = "${
//                    ((progressTime) / 3600000).toString().padStart(2, kotlin.Char(48))
//                } : ${((progressTime) / 60000 % 60).toString().padStart(2, Char(48))} : ${
//                    ((progressTime) / 1000 % 60).toString().padStart(
//                        2,
//                        kotlin.Char(48)
//                    )
//                }",
//                style = MaterialTheme.typography.titleLarge,
//            )
//        }
    }
}



