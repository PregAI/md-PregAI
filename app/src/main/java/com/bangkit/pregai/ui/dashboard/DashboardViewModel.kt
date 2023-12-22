package com.bangkit.pregai.ui.dashboard

import androidx.lifecycle.ViewModel
import pregai.R
import kotlinx.coroutines.flow.MutableStateFlow

class DashboardViewModel : ViewModel() {

    val actionState = MutableStateFlow(R.id.dashboard)

    fun setViewToShow(first: Int) {
        actionState.value =
            if (first == R.id.history)
                R.id.dashboard else R.id.history
    }
}