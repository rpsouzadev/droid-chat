package com.rpsouza.droidchat.ui.feature.signin

import androidx.annotation.StringRes

data class SignInUiState(
    val email: String = "",
    @param:StringRes val emailError: Int? = null,
    val password: String = "",
    @param:StringRes val passwordError: Int? = null,
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false,
    val errorMessageStringResId: Int? = null,
)