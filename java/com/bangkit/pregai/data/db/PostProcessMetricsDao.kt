package com.bangkit.pregai.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bangkit.pregai.model.PostProcessMetrics
import kotlinx.coroutines.flow.Flow

@Dao
interface PostProcessMetricsDao {

    @Query("SELECT * FROM PostProcessMetrics")
    fun getAllMetrics(): Flow<List<PostProcessMetrics>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updatePoses(vararg pose: PostProcessMetrics)
}