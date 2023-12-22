package com.bangkit.pregai.poseprocessor.camera

import android.graphics.Bitmap
import android.graphics.Canvas
import com.bangkit.pregai.poseprocessor.camera.GraphicOverlay.Graphic

/**
 * Draw camera image to background.
 */
class CameraImageGraphic(
    overlay: GraphicOverlay?,
    private val bitmap: Bitmap
) : Graphic(overlay) {
    override fun draw(canvas: Canvas) {
        canvas.drawBitmap(bitmap, transformationMatrix, null)
    }
}