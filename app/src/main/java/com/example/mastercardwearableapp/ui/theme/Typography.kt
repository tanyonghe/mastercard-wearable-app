package com.example.mastercardwearableapp.ui.theme

import com.example.mastercardwearableapp.ui.utils.getInterFontFamily
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

fun getAppTypography(): Typography {
    val interFontFamily: FontFamily = getInterFontFamily()

    return Typography(
        displayLarge = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 57.sp
        ),
        displayMedium = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 45.sp
        ),
        displaySmall = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 36.sp
        ),
        headlineLarge = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 32.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 28.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 24.sp
        ),
        titleLarge = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 22.sp
        ),
        titleMedium = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 16.sp
        ),
        titleSmall = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 14.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 16.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 14.sp
        ),
        bodySmall = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 12.sp
        ),
        labelLarge = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 14.sp
        ),
        labelMedium = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 12.sp
        ),
        labelSmall = TextStyle(
            fontFamily = interFontFamily,
            fontSize = 11.sp
        )
    )
}
