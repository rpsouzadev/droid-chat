package com.rpsouza.droidchat.ui.feature.signin

import androidx.lifecycle.ViewModel
import com.rpsouza.droidchat.R
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
            is SignInUiEvent.SignIn -> formValidation()
        }
    }

    private fun emailChanged(email: String) {
        _uiState.value = _uiState.value.copy(email = email, emailError = null)
    }

    private fun passwordChanged(password: String) {
        _uiState.value = _uiState.value.copy(password = password, passwordError = null)
    }

    private fun formValidation() {
        var isValid = true

        if (_uiState.value.email.isBlank()) {
            _uiState.value = _uiState.value.copy(emailError = R.string.error_message_email_invalid)
            isValid = false
        }

        if (_uiState.value.password.isBlank()) {
            _uiState.value = _uiState.value.copy(passwordError = R.string.error_message_password_invalid)
            isValid = false
        }

        if (isValid) signIn()
    }

    private fun signIn() {
        _uiState.value = _uiState.value.copy(isLoading = true)
    }
}