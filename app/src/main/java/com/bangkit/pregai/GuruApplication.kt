package com.bangkit.pregai

import coil.ImageLoader
import coil.disk.DiskCache
import coil.memory.MemoryCache
import dagger.hilt.android.HiltAndroidApp
import com.bangkit.pregai.logger.Logger
import com.bangkit.pregai.poseprocessor.PoseProcessorMultiDexApplication
import pregai.BuildConfig
import pregai.R

@HiltAndroidApp
class GuruApplication : PoseProcessorMultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Logger.plant(Logger.DebugTree())
        }
        ImageLoader.Builder(this)
            .memoryCache {
                MemoryCache.Builder(this)
                    .maxSizePercent(0.45)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(cacheDir.resolve("svg_pose_image_cache"))
                    .maxSizePercent(0.04)
                    .build()
            }
            .build()
    }
}