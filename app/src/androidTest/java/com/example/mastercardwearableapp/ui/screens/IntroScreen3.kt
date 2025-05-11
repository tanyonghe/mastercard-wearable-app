package com.example.mastercardwearableapp.ui.screens

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mastercardwearableapp.ui.theme.MastercardWearableAppTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IntroScreen3Test {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            navController = TestNavHostController(composeTestRule.activity)
            navController.navigatorProvider.addNavigator(ComposeNavigator())

            MastercardWearableAppTheme {
                NavHost(navController = navController, startDestination = "intro2") {
                    composable("cover") { CoverScreen(navController) }
                    composable("intro1") { IntroScreen1(navController) }
                    composable("intro2") { IntroScreen2(navController) }
                    composable("intro3") { IntroScreen3(navController) }
                    composable("terms") { TermsAndConditionsScreen(navController) }
                }
            }
        }

        composeTestRule.runOnUiThread {
            navController.navigate("intro3")
        }
    }

    @Test
    fun testIntroScreen3_uiElements() {
        composeTestRule.onNodeWithTag("Intro Title").assertTextContains("No charging required", substring = true)
        composeTestRule.onNodeWithTag("Intro Description").assertTextContains("Pay seamlessly and reliably", substring = true)
        composeTestRule.onNodeWithTag("Next Button").assertIsDisplayed()
        composeTestRule.onNodeWithTag("Back Button").assertIsDisplayed()
        composeTestRule.onNodeWithTag("Skip Button").assertIsDisplayed()
    }

    @Test
    fun testNextButton_navigatesToTerms() {
        composeTestRule.onNodeWithTag("Next Button").performClick()
        composeTestRule.waitForIdle()
        assert(navController.currentDestination?.route == "terms")
    }

    @Test
    fun testBackButton_navigatesToIntro2() {
        composeTestRule.onNodeWithTag("Back Button").performClick()
        composeTestRule.waitForIdle()
        assert(navController.currentDestination?.route == "intro2")
    }

    @Test
    fun testCloseButton_navigatesToCover() {
        composeTestRule.onNodeWithTag("Close Button").performClick()
        composeTestRule.waitForIdle()
        assert(navController.currentDestination?.route == "cover")
    }
}
