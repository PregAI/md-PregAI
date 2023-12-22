package com.bangkit.pregai.data.auth

import com.bangkit.pregai.android.data.State

sealed class AuthState : State {
    object SignedOut : AuthState()
    object SignedIn : AuthState()
}