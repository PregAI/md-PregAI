package com.bangkit.pregai.ui.profileScreen

data class ProfileScreenState(
    val username: String = "",
    val profileImage: String = "",
    val isLoading: Boolean = false,
    val isLogoutButtonEnabled: Boolean = true,
)
