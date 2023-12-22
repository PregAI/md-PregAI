package com.bangkit.pregai.ui.profileScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileScreenState())
    val uiState = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<ProfileScreenEvents>()
    val events = _events.asSharedFlow()


    fun onAboutPressed() = viewModelScope.launch {
        _events.emit(ProfileScreenEvents.NavigateToAboutScreen)
    }

    fun onLogoutPressed() = viewModelScope.launch {
//        disableLogoutButton()
        _events.emit(
            ProfileScreenEvents.ShowLogoutDialog(
                "Confirm Logout",
                "Are you sure that you want to logout?"
            )
        )
    }

}
