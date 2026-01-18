package com.rpsouza.droidchat.navigation

import kotlinx.serialization.Serializable

sealed interface DroidChatRouter {
    @Serializable
    object Splash : DroidChatRouter

    @Serializable
    object AuthHome : DroidChatRouter

    @Serializable
    object Login : DroidChatRouter

    @Serializable
    object SignUp : DroidChatRouter

    @Serializable
    object HomeApp : DroidChatRouter
}