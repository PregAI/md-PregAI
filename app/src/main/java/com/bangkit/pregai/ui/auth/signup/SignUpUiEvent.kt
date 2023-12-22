package com.bangkit.pregai.ui.auth.signup

import com.bangkit.pregai.ui.UiEvent

sealed class SignUpUiEvent : UiEvent {
    object OnSignUp : SignUpUiEvent()
    object OnDismissState : SignUpUiEvent()
}