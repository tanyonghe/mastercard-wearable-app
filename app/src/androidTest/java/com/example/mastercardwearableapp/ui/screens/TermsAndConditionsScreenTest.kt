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
class TermsAndConditionsScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            navController = TestNavHostController(composeTestRule.activity)
            navController.navigatorProvider.addNavigator(ComposeNavigator())

            MastercardWearableAppTheme {
                NavHost(navController = navController, startDestination = "intro3") {
                    composable("cover") { CoverScreen(navController) }
                    composable("intro1") { IntroScreen1(navController) }
                    composable("intro2") { IntroScreen2(navController) }
                    composable("intro3") { IntroScreen3(navController) }
                    composable("terms") { TermsAndConditionsScreen(navController) }
                }
            }
        }
        composeTestRule.onRoot().printToLog("TAG")

        composeTestRule.runOnUiThread {
            navController.navigate("terms")
        }
    }

    @Test
    fun testTermsScreen_uiElements() {
        composeTestRule.onNodeWithTag("Terms Title").assertTextContains("Terms and Conditions", substring = true)
        composeTestRule.onNodeWithTag("Agree Button").assertIsDisplayed()
        composeTestRule.onNodeWithTag("Disagree Button").assertIsDisplayed()
    }

    @Test
    fun testHeader_uiElements() {
        composeTestRule.onNodeWithTag("Close Button").assertIsDisplayed()
    }

    @Test
    fun testAgreeButton_navigatesToCover() {
        composeTestRule.onNodeWithTag("Agree Button").performClick()
        composeTestRule.waitForIdle()
        assert(navController.currentDestination?.route == "cover")
    }

    @Test
    fun testDisagreeButton_navigatesToIntro3() {
        composeTestRule.onNodeWithTag("Disagree Button").performClick()
        composeTestRule.waitForIdle()
        assert(navController.currentDestination?.route == "intro3")
    }

    @Test
    fun testCloseButton_navigatesToCover() {
        composeTestRule.onNodeWithTag("Close Button").performClick()
        composeTestRule.waitForIdle()
        assert(navController.currentDestination?.route == "cover")
    }
}
