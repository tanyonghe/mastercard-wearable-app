package com.example.mastercardwearableapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mastercardwearableapp.R

@Composable
fun Footer() {
    Text(
        text = stringResource(R.string.trademark),
        fontSize = 8.sp,
        color = Color(0xFFB1ADA6),
        textAlign = TextAlign.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
    )

    // Space for gesture handle navigation bar
    Spacer(modifier = Modifier.height(8.dp))
}