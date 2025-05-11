package com.example.mastercardwearableapp.ui.utils

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.example.mastercardwearableapp.R

fun getInterFontFamily(): FontFamily {
    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )

    val googleFont = GoogleFont("Inter")

    return FontFamily(
        Font(
            googleFont = googleFont,
            fontProvider = provider,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        )
    )
}
