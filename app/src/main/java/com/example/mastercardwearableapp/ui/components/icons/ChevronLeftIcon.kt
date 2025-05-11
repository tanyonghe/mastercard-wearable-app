package com.example.mastercardwearableapp.ui.components.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mastercardwearableapp.R

@Composable
fun ChevronLeftIcon(onClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.baseline_chevron_left_24),
        contentDescription = "Back",
        modifier = Modifier
            .size(24.dp)
            .clickable { onClick() },
        colorFilter = ColorFilter.tint(Color.White) // optional
    )
}
