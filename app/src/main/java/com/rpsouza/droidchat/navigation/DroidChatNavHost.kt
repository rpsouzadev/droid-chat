package com.rpsouza.droidchat.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun DroidChatNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = DroidChatRouter.Splash) {
        composable<DroidChatRouter.Splash> {}
        composable<DroidChatRouter.AuthHome> {}
        composable<DroidChatRouter.Login> {}
        composable<DroidChatRouter.SignUp> {}
        composable<DroidChatRouter.HomeApp> {}
    }
}