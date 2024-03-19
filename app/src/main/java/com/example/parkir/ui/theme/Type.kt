package com.example.parkir.ui.theme

import androidx.compose.material3.Button
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.parkir.R

// Set of Material typography styles to start with

val Urbanist = FontFamily(
    fonts = listOf(
        Font(R.font.urbanist_thin, weight = FontWeight.Thin),
        Font(R.font.urbanist_extra_light, weight = FontWeight.ExtraLight),
        Font(R.font.urbanist_light, weight = FontWeight.Light),
        Font(R.font.urbanist_regular, weight = FontWeight.Normal),
        Font(R.font.urbanist_medium, weight = FontWeight.Medium),
        Font(R.font.urbanist_semi_bold, weight = FontWeight.SemiBold),
        Font(R.font.urbanist_bold, weight = FontWeight.Bold),
        Font(R.font.urbanist_extra_bold, weight = FontWeight.ExtraBold),
        Font(R.font.urbanist_black, weight = FontWeight.Black),
    )
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Urbanist,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)