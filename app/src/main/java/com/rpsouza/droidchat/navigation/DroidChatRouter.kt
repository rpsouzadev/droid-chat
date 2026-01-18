package com.rpsouza.droidchat.navigation

sealed interface DroidChatRouter {
    object Splash : DroidChatRouter
    object AuthHome : DroidChatRouter
    object Login : DroidChatRouter
    object SignUp : DroidChatRouter
    object HomeApp : DroidChatRouter
}