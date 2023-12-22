package com.bangkit.pregai.poseprocessor

fun interface InferenceInfoGraphicCallback {
    fun onInferenceInfoChangedListener(frameLatency: Long, detectorLatency: Long, framesPerSecond: Int)
}