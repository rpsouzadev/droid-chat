package com.rpsouza.droidchat.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.rpsouza.droidchat.ui.feature.signin.SignInScreen
import com.rpsouza.droidchat.ui.feature.splash.SplashScreen

@Composable
fun DroidChatNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = DroidChatRouter.Splash) {
        composable<DroidChatRouter.Splash> {
            SplashScreen() {
                navController.navigate(
                    route = DroidChatRouter.SignIn,
                    navOptions = navOptions {
                        popUpTo(DroidChatRouter.Splash) {
                            inclusive = true
                        }
                    }
                )
            }
        }
        composable<DroidChatRouter.AuthHome> {}
        composable<DroidChatRouter.SignIn> {
            SignInScreen(
                onRegisterClick = { navController.navigate(route = DroidChatRouter.SignUp) }
            )
        }
        composable<DroidChatRouter.SignUp> {}
        composable<DroidChatRouter.HomeApp> {}
    }
}