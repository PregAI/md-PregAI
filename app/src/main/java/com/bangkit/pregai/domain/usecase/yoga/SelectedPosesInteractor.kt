package com.bangkit.pregai.domain.usecase.yoga

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import com.bangkit.pregai.ui.LightningYogaPosesFactory
import com.bangkit.pregai.domain.SubjectInteractor
import com.bangkit.pregai.model.PoseUiModel
import com.bangkit.pregai.utils.extensions.toFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SelectedPosesInteractor @Inject constructor(
    @ApplicationContext private val context: Context
) : SubjectInteractor<Int, List<PoseUiModel>>() {

    override fun createObservable(params: Int): Flow<List<PoseUiModel>> {
        return LightningYogaPosesFactory.singleton(context)
            .filter { poses ->
                poses.yogaCategories?.map { category ->
                    category.id ?: -1
                }?.contains(params) ?: false
            }.map { poses ->
                PoseUiModel(
                    title = poses.englishName ?: "",
                    description = poses.sanskritName ?: "",
                    thumbnail = null,
                    thumbnailUri = poses.imgUrl,
                    multiPoses = true
                )
            }.toFlow()
    }
}