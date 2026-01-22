package com.rpsouza.droidchat.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.rpsouza.droidchat.ui.theme.DroidChatTheme

@Composable
fun PrimaryButton(
    title: String,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            if (!isLoading) {
                onClick.invoke()
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .height(DroidChatTheme.sizing.dp64)
            .shadow(
                DroidChatTheme.sizing.dp4,
                shape = CircleShape,
                ambientColor = Color.White,
                spotColor = Color.White
            ),
        enabled = !isLoading,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall
        )

        if (isLoading) {
            Spacer(modifier = Modifier.width(DroidChatTheme.sizing.dp8))
            CircularProgressIndicator(
                modifier = Modifier.size(DroidChatTheme.sizing.dp18),
                trackColor = MaterialTheme.colorScheme.onPrimary,
                strokeWidth = DroidChatTheme.sizing.dp2
            )
        }
    }
}

@Composable
@Preview
fun PrimaryButtonPreview() {
    DroidChatTheme {
        PrimaryButton(
            title = "Primary button",
            isLoading = true,
        ) {

        }
    }
}