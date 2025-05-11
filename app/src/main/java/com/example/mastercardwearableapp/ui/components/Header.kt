package com.example.mastercardwearableapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mastercardwearableapp.R
import com.example.mastercardwearableapp.ui.components.icons.ChevronLeftIcon

@Composable
fun Header(screenHeight: Dp, navController: NavController, displayBack: Boolean = false) {
    val logoHeight = screenHeight * 0.04f

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight * 0.09f)
            .background(Color.Black.copy(alpha = 0.5f))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.height(logoHeight)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(R.string.logo_name), color = Color.White, fontSize = 18.sp)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (displayBack) {
                ChevronLeftIcon({ navController.popBackStack() })
            }
            Spacer(modifier = Modifier.width(12.dp))
            Button(
                onClick = { navController.navigate("cover") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F00)),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                modifier = Modifier.testTag("Close Button")
            ) {
                Text(stringResource(R.string.close_button), color = Color.White, fontSize = 16.sp)
            }
        }

    }
}