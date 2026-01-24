package com.rpsouza.droidchat.ui.feature.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.rpsouza.droidchat.R
import com.rpsouza.droidchat.ui.components.Logo
import com.rpsouza.droidchat.ui.components.PrimaryButton
import com.rpsouza.droidchat.ui.components.PrimaryTextField
import com.rpsouza.droidchat.ui.theme.BackgroundGradient
import com.rpsouza.droidchat.ui.theme.DroidChatTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(
    viewModel: SignInViewModel = koinViewModel()
) {
    val state = viewModel.uiState.collectAsState().value
    SignUpScreenContent(state = state, event = viewModel::onEvent)
}

@Composable
private fun SignUpScreenContent(
    state: SignInUiState,
    event: (SignInUiEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(brush = BackgroundGradient)
            .padding(DroidChatTheme.sizing.dp16),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Logo()

        Column(
            modifier = Modifier.padding(top = DroidChatTheme.sizing.dp32),
            verticalArrangement = Arrangement.spacedBy(DroidChatTheme.sizing.dp16)
        ) {
            PrimaryTextField(
                value = state.email,
                leftIcon = R.drawable.ic_envelope,
                placeholder = stringResource(R.string.feature_login_email),
                keyboardType = KeyboardType.Email,
                errorMessage = state.emailError?.let { stringResource(it) },
            ) { email -> event(SignInUiEvent.EmailChanged(email)) }

            PrimaryTextField(
                value = state.password,
                leftIcon = R.drawable.ic_lock,
                placeholder = stringResource(R.string.feature_login_password),
                keyboardType = KeyboardType.Password,
                errorMessage = state.passwordError?.let { stringResource(it) },
            ) { password -> event(SignInUiEvent.PasswordChanged(password)) }
        }

        Column(
            modifier = Modifier.padding(top = DroidChatTheme.sizing.dp32),
            verticalArrangement = Arrangement.spacedBy(DroidChatTheme.sizing.dp16)
        ) {
            PrimaryButton(
                title = stringResource(R.string.feature_login_button),
                isLoading = state.isLoading,
            ) { event(SignInUiEvent.SignIn) }
        }
    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    DroidChatTheme {
        SignUpScreenContent(
            state = SignInUiState(),
            event = {}
        )
    }
}