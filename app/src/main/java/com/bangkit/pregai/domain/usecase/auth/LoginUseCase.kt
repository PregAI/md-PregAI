package com.bangkit.pregai.domain.usecase.auth

import com.bangkit.pregai.domain.UiStateFlowUseCase
import com.bangkit.pregai.domain.UseCaseParams
import com.bangkit.pregai.ui.auth.login.LoginUiState
import com.bangkit.pregai.data.Result
import com.bangkit.pregai.data.auth.UserCredentials
import com.bangkit.pregai.data.auth.UserDataSource
import com.bangkit.pregai.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginUseCase @Inject constructor(
    private val authDataSource: UserDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : UiStateFlowUseCase<LoginUseCase.Params, LoginUiState>(ioDispatcher) {

    data class Params(val credentials: UserCredentials) : UseCaseParams.Params()

    override fun execute(params: Params): Flow<LoginUiState> {
        val (username, email, _) = params.credentials

        if (username.isEmpty() && email.isEmpty()) {
            return flowOf(
                LoginUiState(
                    isAuthenticated = false,
                    enableSubmitButton = false,
                    error = "Email or username should not be empty."
                )
            )
        }

        return authDataSource.login(params.credentials).map { result ->
            when (result) {
                is Result.Loading -> {
                    LoginUiState(
                        isLoading = true,
                        isAuthenticated = false,
                        enableSubmitButton = false
                    )
                }
                is Result.Success -> {
                    LoginUiState(
                        isLoading = false,
                        isAuthenticated = result.data.getUid() != null,
                        enableSubmitButton = false
                    )
                }
                is Result.Error -> {
                    LoginUiState(
                        isLoading = false,
                        isAuthenticated = false,
                        enableSubmitButton = true,
                        error = result.exception
                    )
                }
            }
        }
    }
}