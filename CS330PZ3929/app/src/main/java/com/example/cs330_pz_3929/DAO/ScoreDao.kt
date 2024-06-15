package com.example.cs330_pz_3929.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cs330_pz_3929.Entity.Score

@Dao
interface ScoreDao {

    @Query("SELECT * FROM scores ORDER BY score DESC")
    fun getAllScores(): LiveData<List<Score>>

    @Insert
    suspend fun insert(score: Score)
}