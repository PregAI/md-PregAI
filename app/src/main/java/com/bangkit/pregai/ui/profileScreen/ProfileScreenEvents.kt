package com.bangkit.pregai.ui.profileScreen

sealed class ProfileScreenEvents {

    object NavigateToAboutScreen : ProfileScreenEvents()

    data class ShowLogoutDialog(
        val title: String,
        val description: String
    ) : ProfileScreenEvents()

    object Logout : ProfileScreenEvents()

}
