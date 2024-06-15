package com.example.cs330_pz_3929

import androidx.lifecycle.LiveData


class ScoreRepository(private val scoreDao: ScoreDao) {

    fun getAllScores(): LiveData<List<Score>> {
        return scoreDao.getAllScores()
    }

    suspend fun insert(score: Score) {
        scoreDao.insert(score)
    }
}