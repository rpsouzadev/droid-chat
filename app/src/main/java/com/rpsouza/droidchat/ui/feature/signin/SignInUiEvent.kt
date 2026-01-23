package com.rpsouza.droidchat.ui.feature.signin

sealed interface SignInUiEvent {
    data class EmailChanged(val email: String) : SignInUiEvent
    data class PasswordChanged(val password: String) : SignInUiEvent
    object SignIn : SignInUiEvent
}