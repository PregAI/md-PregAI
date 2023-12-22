package com.bangkit.pregai.ui.auth.login

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pregai.R
import pregai.databinding.FragmentLoginBinding
import com.bangkit.pregai.logger.Logger
import com.bangkit.pregai.utils.binding.ViewBindingFragment
import com.bangkit.pregai.utils.extensions.launchWithViewLifecycle
import com.bangkit.pregai.utils.extensions.navigate
import com.bangkit.pregai.utils.extensions.setupLoadingState
import com.bangkit.pregai.widget.SnackbarMessage
import com.bangkit.pregai.widget.SnackbarMessageManager
import com.bangkit.pregai.widget.setupSnackbarManager
import javax.inject.Inject

/**
 * [LoginFragment] for authenticating users.
 */
@AndroidEntryPoint
class LoginFragment : ViewBindingFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    @Inject
    lateinit var messageManager: SnackbarMessageManager

    private val viewModel by viewModels<LoginViewModel>()

    override fun viewDidLoad(binding: FragmentLoginBinding?) {
        setupSnackbarManager(messageManager)

        launchWithViewLifecycle {
            viewModel.uiEvent.collect {
                if (it is LoginUiEvent.Login) {
                    navigate(R.id.action_login_fragment_to_dashboard)
                }
            }
        }

        launchWithViewLifecycle {
            viewModel.uiEvent.collect {
                if (it is LoginUiEvent.Create) {
                    navigate(R.id.action_login_fragment_to_sign_up_fragment)
                }
            }
        }

    }

    override fun invalidate() = withState(viewModel) { state ->
        setupLoadingState(state.isLoading)

        Logger.d("State: $state")

        if (!state.error.isNullOrEmpty()) {
            val message = SnackbarMessage(message = state.error)
            messageManager.addMessage(message)
        }

        if (state.isAuthenticated) {
            Logger.e("Authenticated...")
        }
    }
}