package com.bangkit.pregai.ui.auth.signup

import com.bangkit.pregai.ui.UiState

data class SignUpUiState(
    val isLoading: Boolean?,
    val isSuccess: Boolean,
    val enableSubmitButton: Boolean,
    val error: String? = null
) : UiState {

    companion object {
        fun unauthenticated(): SignUpUiState {
            return SignUpUiState(
                isLoading = null,
                isSuccess = false,
                enableSubmitButton = false
            )
        }
    }
}