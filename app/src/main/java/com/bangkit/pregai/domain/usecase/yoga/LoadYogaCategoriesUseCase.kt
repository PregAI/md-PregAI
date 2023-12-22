package com.bangkit.pregai.domain.usecase.yoga

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import com.bangkit.pregai.ui.LightningYogaPosesFactory
import com.bangkit.pregai.di.IoDispatcher
import com.bangkit.pregai.domain.BaseFlowUseCase
import com.bangkit.pregai.domain.UseCaseParams
import com.bangkit.pregai.utils.extensions.toFlow
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoadYogaCategoriesUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : BaseFlowUseCase<LoadYogaCategoriesUseCase.Params, List<String>>(ioDispatcher) {

    private val regex = Regex("(Yoga|Poses)")

    object Params : UseCaseParams.Params()

    override fun execute(params: Params): Flow<List<String>> {
        return LightningYogaPosesFactory.singleton(context)
            .flatMap { poses ->
                poses.yogaCategories?.map { it.name } ?: emptyList()
            }
            .distinct()
            .map { name ->
                name?.replace(regex, "") ?: "".trimStart()
            }.toFlow()
    }

    override fun mapExceptionToResult(throwable: Throwable) = emptyList<String>()
}