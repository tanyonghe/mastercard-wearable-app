package com.example.mastercardwearableapp.ui.utils

import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import com.example.mastercardwearableapp.R

@Composable
fun GetTermsAndConditions() {
    val context = LocalContext.current
    AndroidView(factory = {
        TextView(it).apply {
            text = HtmlCompat.fromHtml(
                context.getString(R.string.terms_and_conditions),
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )
            setTextColor(Color.White.toArgb())
        }
    })
}
