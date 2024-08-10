package com.example.cs330_pz_3929.Repository

import androidx.lifecycle.LiveData
import com.example.cs330_pz_3929.DAO.ScoreDao
import com.example.cs330_pz_3929.Entity.Score
import javax.inject.Inject

class ScoreRepository @Inject constructor(private val scoreDao: ScoreDao) {
    fun getAllScores(): LiveData<List<Score>> = scoreDao.getAllScores()

    suspend fun insert(score: Score) {
        scoreDao.insert(score)
    }
}