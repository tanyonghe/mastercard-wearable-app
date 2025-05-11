package com.example.mastercardwearableapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.*
import androidx.navigation.compose.NavHost
import com.example.mastercardwearableapp.ui.screens.TermsAndConditionsScreen
import com.example.mastercardwearableapp.ui.screens.CoverScreen
import com.example.mastercardwearableapp.ui.screens.IntroScreen1
import com.example.mastercardwearableapp.ui.screens.IntroScreen2
import com.example.mastercardwearableapp.ui.screens.IntroScreen3
import com.example.mastercardwearableapp.ui.theme.MastercardWearableAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MastercardWearableAppTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "cover") {
                    composable("cover") { CoverScreen(navController) }
                    composable("intro1") { IntroScreen1(navController) }
                    composable("intro2") { IntroScreen2(navController) }
                    composable("intro3") { IntroScreen3(navController) }
                    composable("terms") { TermsAndConditionsScreen(navController) }
                }
            }
        }
    }
}
