package com.bangkit.pregai.ui.onboarding

sealed class OnBoardingScreenEvents {
    object NavigateToLoginScreen : OnBoardingScreenEvents()
    class ShowNextPage(val pageNo: Int) : OnBoardingScreenEvents()
}
