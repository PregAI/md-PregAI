package com.bangkit.pregai.poseprocessor

import com.bangkit.pregai.poseprocessor.classification.PoseClassifierProcessor

fun interface ConfidencePoseGraphicCallback {
    fun onGetPoseClassificationChangeListener(result: List<PoseClassifierProcessor.PoseResult>)
}