package com.rpsouza.droidchat.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val LocalSizing = compositionLocalOf { Sizing() }

data class Sizing(
    val none: Dp = 0.dp,
    val dp1: Dp = 1.dp,
    val dp2: Dp = 2.dp,
    val dp4: Dp = 4.dp,
    val dp8: Dp = 8.dp,
    val dp16: Dp = 16.dp,
    val dp18: Dp = 18.dp,
    val dp24: Dp = 24.dp,
    val dp32: Dp = 32.dp,
    val dp48: Dp = 48.dp,
    val dp64: Dp = 64.dp,
    val dp128: Dp = 128.dp,
    val dp150: Dp = 150.dp,
    val dp256: Dp = 256.dp
)