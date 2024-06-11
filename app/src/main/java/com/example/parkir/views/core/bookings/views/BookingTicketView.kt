package com.example.parkir.views.core.bookings.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import com.example.parkir.R
import com.example.parkir.views.ui.theme.black
import com.example.parkir.views.ui.theme.grey
import com.example.parkir.views.ui.theme.primary
import com.example.parkir.views.ui.theme.primaryCC
import com.example.parkir.views.ui.theme.white
import com.lightspark.composeqr.DotShape
import com.lightspark.composeqr.QrCodeColors
import com.lightspark.composeqr.QrCodeView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.logging.Logger
import kotlin.math.roundToInt

@Composable
fun BookingTicketView(
    navController: NavHostController,
    bookingsViewModel: BookingsViewModel,
    bookingId: Int
) {

    var vScrollState: ScrollState = rememberScrollState()
    val logger: Logger = Logger.getLogger("naving")
    logger.info("id $bookingId")

    LaunchedEffect(key1 = 1) {
        CoroutineScope(Dispatchers.IO).launch {
            bookingsViewModel.getBookingById(bookingId = bookingId)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colorStops = arrayOf(
                        0.0f to primaryCC,
                        1f to primary,
                    ),
                    start = androidx.compose.ui.geometry.Offset.Zero,
                    end = androidx.compose.ui.geometry.Offset.Infinite
                ),
            ),
        contentAlignment = Alignment.Center,
    ) {
        if (!bookingsViewModel.isLoading) {

            val booking = bookingsViewModel.selectedBooking;

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .padding(30.dp)
                    .background(
                        white, TicketShape2(20.dp, CornerSize(20.dp))
                    )
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                val purple = Color(0xFF552583)
                val gold = Color(0xFFFDB927)
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    
                ) {
                    Text(text = "${booking?.parkingSpot?.number} ${booking?.parkingSpot?.floor?.name}")
                    Spacer(modifier = Modifier.height(15.dp))
                    QrCodeView(
                        data = bookingsViewModel.selectedBooking?.id.toString(),
                        modifier = Modifier
                            .size(200.dp),
                        colors = QrCodeColors(
                            background = white,
                            foreground = black
                        ),
                        dotShape = DotShape.Square,
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(white)
                                .padding(5.dp),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.parkir),
                                contentDescription = "Parkir",
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(CircleShape),
                            )
                        }
                    }
                }
                Box(
                    Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(grey, shape = DottedShape(step = 10.dp))
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 30.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row {
                        Column (
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Name", style = MaterialTheme.typography.bodyMedium)
                            Text("KENNICHE AbdErrazak", style = MaterialTheme.typography.titleMedium)
                        }

                        Column(modifier = Modifier.weight(1f)) {

                        }

                    }

                    Row {
                        Column (
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Parking Area", style = MaterialTheme.typography.bodyMedium)
                            Text("${booking?.parkingSpot?.floor?.parking?.address?.city}", style = MaterialTheme.typography.titleMedium)
                        }

                        Column (
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Parking Spot", style = MaterialTheme.typography.bodyMedium)
                            Text("${booking?.parkingSpot?.number} ${booking?.parkingSpot?.floor?.name}", style = MaterialTheme.typography.titleMedium)
                        }
                    }

                    Row {
                        Column (
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Date", style = MaterialTheme.typography.bodyMedium)
                            Text("${booking?.date}", style = MaterialTheme.typography.titleMedium)
                        }

                        Column (
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Duration", style = MaterialTheme.typography.bodyMedium)
                            Text("${booking!!.duration.substring(booking!!.duration.indexOf("T") + 1, booking!!.duration.indexOf("H"))}  Hours", style = MaterialTheme.typography.titleMedium)
                        }
                    }
                }
            }}

    }
}


class TicketShape2(
    private val circleRadius: Dp,
    private val cornerSize: CornerSize
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(path = getPath(size, density))
    }

    private fun getPath(size: Size, density: Density): Path {
        val roundedRect = RoundRect(size.toRect(), CornerRadius(cornerSize.toPx(size, density)))
        val roundedRectPath = Path().apply { addRoundRect(roundedRect) }
        return Path.combine(
            operation = PathOperation.Intersect,
            path1 = roundedRectPath,
            path2 = getTicketPath(size, density)
        )
    }

    private fun getTicketPath(size: Size, density: Density): Path {
        val middleY = size.height.div(other = 2)
        val circleRadiusInPx = with(density) { circleRadius.toPx() }
        return Path().apply {

            reset()

            lineTo(x = 0F, y = 0F)

            lineTo(x = size.width, y = 0F)

            lineTo(x = size.width, y = middleY.minus(circleRadiusInPx))

            arcTo(
                rect = Rect(
                    left = size.width.minus(circleRadiusInPx),
                    top = middleY.minus(circleRadiusInPx),
                    right = size.width.plus(circleRadiusInPx),
                    bottom = middleY.plus(circleRadiusInPx)
                ),
                startAngleDegrees = 270F,
                sweepAngleDegrees = -270F,
                forceMoveTo = false
            )

            lineTo(x = size.width, y = size.height)

            lineTo(x = 0F, y = size.height)

            lineTo(x = 0F, y = middleY.plus(circleRadiusInPx))

            arcTo(
                rect = Rect(
                    left = 0F.minus(circleRadiusInPx),
                    top = middleY.minus(circleRadiusInPx),
                    right = 0F.plus(circleRadiusInPx),
                    bottom = middleY.plus(circleRadiusInPx)
                ),
                startAngleDegrees = 90F,
                sweepAngleDegrees = -270F,
                forceMoveTo = false
            )

            lineTo(x = 0F, y = 0F)

        }
    }
}

private data class DottedShape(
    val step: Dp,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ) = Outline.Generic(Path().apply {
        val stepPx = with(density) { step.toPx() }
        val stepsCount = (size.width / stepPx).roundToInt() + 1
        val actualStep = size.width / stepsCount
        val dotSize = Size(width = actualStep / 2, height = size.height)
        for (i in 0 until stepsCount) {
            addRect(
                Rect(
                    offset = Offset(x = i * actualStep, y = 0f),
                    size = dotSize
                )
            )
        }
        close()
    })
}