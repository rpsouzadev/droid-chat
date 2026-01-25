package com.rpsouza.droidchat.extension

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

fun KeyboardType.isPassword() = this == KeyboardType.Password

fun KeyboardType.getVisualTransFormationForPassword(visibility: Boolean): VisualTransformation {
    return if (this.isPassword()) {
        if (visibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    } else {
        VisualTransformation.None
    }
}