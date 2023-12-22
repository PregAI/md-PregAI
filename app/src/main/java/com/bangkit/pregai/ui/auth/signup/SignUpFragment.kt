package com.bangkit.pregai.ui.auth.signup

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pregai.R
import com.bangkit.pregai.widget.SnackbarMessage
import com.bangkit.pregai.widget.SnackbarMessageManager
import com.bangkit.pregai.widget.setupSnackbarManager
import pregai.databinding.FragmentSignUpBinding
import com.bangkit.pregai.utils.binding.ViewBindingFragment
import com.bangkit.pregai.utils.extensions.setupLoadingState
import javax.inject.Inject

@AndroidEntryPoint
class SignUpFragment : ViewBindingFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up) {

    @Inject
    lateinit var messageManager: SnackbarMessageManager

    private val viewModel: SignUpViewModel by viewModels()

    override fun viewDidLoad(binding: FragmentSignUpBinding?) {
        setupSnackbarManager(messageManager)
    }

    override fun invalidate() = withState(viewModel) { state ->
        setupLoadingState(state.isLoading)
        if (state.isSuccess) {
            val modal = SignUpStateModalSheet()
            modal.show(childFragmentManager, SignUpStateModalSheet.TAG)
        }

        if (!state.error.isNullOrEmpty()) {
            val message = SnackbarMessage(message = state.error)
            messageManager.addMessage(message)
        }
    }
}