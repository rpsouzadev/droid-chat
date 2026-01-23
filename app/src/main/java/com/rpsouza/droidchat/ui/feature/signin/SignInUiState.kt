package com.rpsouza.droidchat.ui.feature.signin

data class SignInUiState(
    val email: String = "",
    val emailError: Int? = null,
    val password: String = "",
    val passwordError: Int? = null,
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false,
    val errorMessageStringResId: Int? = null,
)