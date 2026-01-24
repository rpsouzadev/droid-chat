package com.rpsouza.droidchat.ui.feature.signin

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
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
    viewModel: SignInViewModel = koinViewModel(),
    onRegisterClick: () -> Unit,
) {
    val state = viewModel.uiState.collectAsState().value
    SignUpScreenContent(
        state = state,
        event = viewModel::onEvent,
        onRegisterClick = onRegisterClick
    )
}

@Composable
private fun SignUpScreenContent(
    state: SignInUiState,
    event: (SignInUiEvent) -> Unit,
    onRegisterClick: () -> Unit,
) {
    val noAccountLabel = stringResource(R.string.feature_login_no_account)
    val registerLabel = stringResource(R.string.feature_login_register)

    val annotated = buildAnnotatedString {
        withStyle(SpanStyle(color = Color.White)) {
            append(noAccountLabel)
            append(" ")
        }

        pushLink(
            LinkAnnotation.Clickable(
                tag = "register",
                styles = TextLinkStyles(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary,
                        textDecoration = TextDecoration.Underline,
                    )
                ),
                linkInteractionListener = { onRegisterClick() }
            )
        )
        append(registerLabel)

        pop()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(brush = BackgroundGradient)
            .padding(DroidChatTheme.sizing.dp16),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Logo(
            modifier = Modifier.weight(2f)
        )

        Column(
            modifier = Modifier
                .weight(1f),
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
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            PrimaryButton(
                title = stringResource(R.string.feature_login_button),
                isLoading = state.isLoading,
            ) { event(SignInUiEvent.SignIn) }

            Text(
                text = annotated,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    DroidChatTheme {
        SignUpScreenContent(
            state = SignInUiState(),
            event = {},
            onRegisterClick = {}
        )
    }
}