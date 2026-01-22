package com.rpsouza.droidchat.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.rpsouza.droidchat.R
import com.rpsouza.droidchat.ui.theme.DroidChatTheme

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null,
        modifier = modifier
    )
}

@Preview
@Composable
private fun LogoPreview() {
    DroidChatTheme {
        Logo()
    }
}