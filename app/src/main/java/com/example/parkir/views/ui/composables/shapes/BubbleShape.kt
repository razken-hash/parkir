package com.example.parkir.views.ui.composables.shapes

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection


class BublleShape(
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
        val center = size.width / 2
        return Path().apply {

            reset()

            // Big Circle
            addOval(
                Rect(
                    radius = center - 40,
                    center = Offset(center, center)
                )
            )

            // TopLeft Circle
            addOval(
                Rect(
                    radius = 15f,
                    center = Offset(30f, 30f)
                )
            )

            // Top Center
            addOval(
                Rect(
                    radius = 5f,
                    center = Offset(center + 10, 20f)
                )
            )

            // TopRight Circle
            addOval(
                Rect(
                    radius = 11f,
                    center = Offset(size.width - 40, 40f)
                )
            )

            // CenterLeft Circle
            addOval(
                Rect(
                    radius = 5f,
                    center = Offset(15f, center - 20)
                )
            )
            // CenterLeft Circle
            addOval(
                Rect(
                    radius = 8f,
                    center = Offset(40f, size.width - 50)
                )
            )

            // Bottom Center
            addOval(
                Rect(
                    radius = 5f,
                    center = Offset(center - 20, size.width - 20)
                )
            )

            // Bottom Center
            addOval(
                Rect(
                    radius = 3f,
                    center = Offset(center + 40, size.width - 25)
                )
            )

            // Bottom Center
            addOval(
                Rect(
                    radius = 3f,
                    center = Offset(center + 40, size.width - 25)
                )
            )

            // Bottom Right
            addOval(
                Rect(
                    radius = 5f,
                    center = Offset(size.width - 40, size.width - 60)
                )
            )

            // CenterRight
            addOval(
                Rect(
                    radius = 5f,
                    center = Offset(size.width - 20, center - 5)
                )
            )

        }
    }
}