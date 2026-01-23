package com.rpsouza.droidchat.ui.feature.signin

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignInViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()

    fun onEvent(event: SignInUiEvent) {
        when (event) {
            is SignInUiEvent.EmailChanged -> emailChanged(event.email)
            is SignInUiEvent.PasswordChanged -> passwordChanged(event.password)
            is SignInUiEvent.SignIn -> signIn()
        }
    }

    private fun emailChanged(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
    }

    private fun passwordChanged(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    private fun signIn() {
        _uiState.value = _uiState.value.copy(isLoading = true)
    }
}