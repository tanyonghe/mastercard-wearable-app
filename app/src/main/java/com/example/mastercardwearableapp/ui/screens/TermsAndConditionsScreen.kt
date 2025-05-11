package com.example.mastercardwearableapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mastercardwearableapp.R
import com.example.mastercardwearableapp.ui.components.Footer
import com.example.mastercardwearableapp.ui.components.Header
import com.example.mastercardwearableapp.ui.utils.GetTermsAndConditions

@Composable
fun TermsAndConditionsScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    val scrollBarHeight = with(LocalDensity.current) {
        val containerHeightPx = screenHeight.toPx()
        val contentHeightPx = scrollState.maxValue + containerHeightPx
        val visibleRatio = containerHeightPx / contentHeightPx
        (screenHeight * visibleRatio).coerceIn(24.dp, screenHeight)
    }

    val scrollOffset = with(LocalDensity.current) {
        val visibleScrollAreaPx = (screenHeight * 0.8f).toPx()
        val maxOffsetPx = visibleScrollAreaPx - scrollBarHeight.toPx()
        val scrollRatio = scrollState.value / (scrollState.maxValue.toFloat() + 0.01f)
        (maxOffsetPx * scrollRatio).toDp()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight * 0.9f)) {
            Header(screenHeight = screenHeight, navController = navController)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                Text(
                    text = stringResource(R.string.terms_and_conditions_title),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .testTag("Terms Title")
                )
            }

            Box(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
                    .weight(1f)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF2A2A2A))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 8.dp) // spacing for scrollbar
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState)
                            .padding(16.dp)
                            .testTag("Terms Content")
                    ) {
                        GetTermsAndConditions()
                    }
                }

                // Custom scrollbar
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                        .width(4.dp)
                        .height(screenHeight * 0.07f)
                        .offset(y = scrollOffset)
                        .background(Color.White, shape = RoundedCornerShape(4.dp))
                )
            }
        }

        // Bottom fixed section
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.Black)
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedButton(
                    onClick = { navController.popBackStack() },
                    border = BorderStroke(1.dp, Color(0xFFFF6F00)),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFFFF6F00),
                        containerColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(screenWidth * 0.25f)
                        .height(screenHeight * 0.04f)
                        .testTag("Disagree Button")
                ) {
                    Text(stringResource(R.string.disagree_button), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
                Button(
                    onClick = { navController.navigate("cover") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F00)),
                    modifier = Modifier
                        .width(screenWidth * 0.55f)
                        .height(screenHeight * 0.04f)
                        .testTag("Agree Button")
                ) {
                    Text(stringResource(R.string.agree_button), fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Footer()
        }
    }
}
