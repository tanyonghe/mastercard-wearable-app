package com.example.mastercardwearableapp.ui.components.text

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun StrokeText(
    text: String,
    fontSize: TextUnit = 64.sp,
    strokeWidth: Float = 4f,
    strokeColor: Color = Color.White,
    strokeJoin: Paint.Join = Paint.Join.ROUND,
    typeface: Typeface? = Typeface.MONOSPACE,
    testTag: String = ""
) {
    val density = LocalDensity.current
    val textPxSize = with(density) { fontSize.toPx() }

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(with(density) { fontSize.toDp() * 2 })
            .testTag(testTag)
    ) {
        drawIntoCanvas { canvas ->
            val paint = android.graphics.Paint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.STROKE
                color = strokeColor.toArgb()
                textSize = textPxSize
                this.strokeWidth = strokeWidth
                this.strokeJoin = strokeJoin
                this.typeface = typeface
            }

            val x = 0f
            val y = textPxSize

            canvas.nativeCanvas.drawText(text, x, y, paint)
        }
    }
}