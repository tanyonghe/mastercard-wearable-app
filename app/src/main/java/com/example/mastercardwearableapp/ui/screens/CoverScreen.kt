package com.example.mastercardwearableapp.ui.screens

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.NavController
import com.example.mastercardwearableapp.R
import com.example.mastercardwearableapp.ui.components.Footer
import com.example.mastercardwearableapp.ui.components.text.StrokeText

@Composable
fun CoverScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.cover),
            contentDescription = "Cover Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight)
                .testTag("Cover Image")
        )
        // Overlay text
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp)
        ) {
            // Logo row
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.logo), // Add to drawable
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(screenHeight * 0.06f)
                        .testTag("Logo")
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.logo_name),
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Title texts
            Text(
                text = stringResource(R.string.cover_title),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.testTag("Cover Title")
            )

            val context = LocalContext.current

            StrokeText(
                text = stringResource(R.string.cover_stroke_title),
                fontSize = 36.sp,
                strokeWidth = 1f,
                strokeColor = Color.White,
                strokeJoin = Paint.Join.ROUND,
                typeface = ResourcesCompat.getFont(context, R.font.inter_bold),
                testTag = "Cover Stroke Title"
            )




            Spacer(modifier = Modifier.height(8.dp))

            // Subtitle
            Text(
                text = stringResource(R.string.cover_subtitle),
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.9f),
                modifier = Modifier.testTag("Cover Subtitle")
            )

            Spacer(modifier = Modifier.weight(1f))
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate("intro1") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F00)),
                modifier = Modifier
                    .width(screenWidth * 0.85f)
                    .height(screenHeight * 0.04f)
                    .testTag("Continue Button")
            ) {
                Text(
                    stringResource(R.string.continue_button),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Footer()
        }
    }
}

