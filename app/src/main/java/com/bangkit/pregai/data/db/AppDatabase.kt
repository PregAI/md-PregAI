package com.bangkit.pregai.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bangkit.pregai.model.CustomizePose
import com.bangkit.pregai.model.PostProcessMetrics

@Database(
    entities = [CustomizePose::class, PostProcessMetrics::class],
    exportSchema = false,
    version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun customizePosesDao(): CustomizePosesDao
    abstract fun postProcessMetricsDao(): PostProcessMetricsDao
}