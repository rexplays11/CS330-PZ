package com.example.cs330_pz_3929

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoreDao {

    @Query("SELECT * FROM scores ORDER BY score DESC")
    fun getAllScores(): LiveData<List<Score>>

    @Insert
    suspend fun insert(score: Score)
}