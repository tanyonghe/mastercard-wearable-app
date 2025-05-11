package com.example.mastercardwearableapp.ui.screens

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
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
class CoverScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            navController = TestNavHostController(composeTestRule.activity)
            navController.navigatorProvider.addNavigator(ComposeNavigator())

            MastercardWearableAppTheme {
                NavHost(navController = navController, startDestination = "cover") {
                    composable("cover") { CoverScreen(navController) }
                    composable("intro1") { IntroScreen1(navController) }
                    composable("intro2") { IntroScreen2(navController) }
                    composable("intro3") { IntroScreen3(navController) }
                    composable("terms") { TermsAndConditionsScreen(navController) }
                }
            }
        }
    }

    @Test
    fun testCoverScreen_uiElements() {
        composeTestRule.onNodeWithTag("Cover Image")
            .assertIsDisplayed()

        composeTestRule.onNodeWithTag("Logo")
            .assertIsDisplayed()

        composeTestRule.onNodeWithTag("Cover Title")
            .assertIsDisplayed()

        composeTestRule.onNodeWithTag("Cover Stroke Title")
            .assertIsDisplayed()

        composeTestRule.onNodeWithTag("Cover Subtitle")
            .assertIsDisplayed()

        composeTestRule.onNodeWithTag("Continue Button")
            .assertIsDisplayed()
    }

    @Test
    fun testContinueButton_navigatesToIntro1() {
        composeTestRule.onNodeWithTag("Continue Button").performClick()
        composeTestRule.waitForIdle()
        assert(navController.currentDestination?.route == "intro1")
    }
}
