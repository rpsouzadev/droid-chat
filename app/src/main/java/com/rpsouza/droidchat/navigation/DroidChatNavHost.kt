package com.rpsouza.droidchat.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rpsouza.droidchat.ui.feature.splash.SplashScreen

@Composable
fun DroidChatNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = DroidChatRouter.Splash) {
        composable<DroidChatRouter.Splash> { SplashScreen() }
        composable<DroidChatRouter.AuthHome> {}
        composable<DroidChatRouter.Login> {}
        composable<DroidChatRouter.SignUp> {}
        composable<DroidChatRouter.HomeApp> {}
    }
}