package com.example.mastercardwearableapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mastercardwearableapp.R
import com.example.mastercardwearableapp.ui.components.Footer
import com.example.mastercardwearableapp.ui.components.Header

@Composable
fun IntroScreen1(navController: NavController) {
    IntroScreenBase(
        navController = navController,
        imageRes = R.drawable.intro1,
        title = stringResource(R.string.intro1_title),
        description = stringResource(R.string.intro1_description),
        onContinue = { navController.navigate("intro2") },
        pageIndex = 0
    )
}

@Composable
fun IntroScreen2(navController: NavController) {
    IntroScreenBase(
        navController = navController,
        imageRes = R.drawable.intro2,
        title = stringResource(R.string.intro2_title),
        description = stringResource(R.string.intro2_description),
        onContinue = { navController.navigate("intro3") },
        pageIndex = 1
    )
}

@Composable
fun IntroScreen3(navController: NavController) {
    IntroScreenBase(
        navController = navController,
        imageRes = R.drawable.intro3,
        title = stringResource(R.string.intro3_title),
        description = stringResource(R.string.intro3_description),
        onContinue = { navController.navigate("terms") },
        pageIndex = 2
    )
}

@Composable
fun IntroScreenBase(
    navController: NavController,
    imageRes: Int,
    title: String,
    description: String,
    onContinue: () -> Unit,
    pageIndex: Int
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val titleFontSize = (screenHeight.value * 0.024f).sp
    val descFontSize = (screenHeight.value * 0.016f).sp

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Intro Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.55f)
        )


        Header(screenHeight = screenHeight, navController = navController, displayBack = true)

        // Bottom content container (fixed at bottom)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.45f)
                .align(Alignment.BottomCenter)
                .background(Color.Black)
        ) {
            Column(
                modifier = Modifier
                    .width(screenWidth * 0.75f)
                    .align(Alignment.TopStart)
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                // Page indicator
                Row(
                    modifier = Modifier.padding(bottom = 12.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    repeat(3) { index ->
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(
                                    color = if (index == pageIndex) Color(0xFFFF6F00) else Color.Gray,
                                    shape = CircleShape
                                )
                        )
                        if (index < 2) Spacer(modifier = Modifier.width(6.dp))
                    }
                }

                // Title
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = titleFontSize,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.testTag("Intro Title")
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Description
                Text(
                    text = description,
                    color = Color.White.copy(alpha = 0.85f),
                    fontSize = descFontSize,
                    modifier = Modifier.testTag("Intro Description")
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Skip button
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append(stringResource(R.string.skip_button))
                        }
                    },
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = descFontSize,
                    modifier = Modifier
                        .clickable { /*navController.navigate("terms")*/ }
                        .testTag("Skip Button")
                )
            }

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 24.dp, vertical = 16.dp)
            ) {
                // Buttons row (Back and Next)
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
                            .testTag("Back Button")
                    ) {
                        Text(
                            stringResource(R.string.back_button),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Button(
                        onClick = onContinue,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F00)),
                        modifier = Modifier
                            .width(screenWidth * 0.55f)
                            .height(screenHeight * 0.04f)
                            .testTag("Next Button")
                    ) {
                        Text(
                            stringResource(R.string.next_button),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Footer()
            }
        }

    }
}
