package com.example.cs330_pz_3929.data.kolekcija.repository

import androidx.lifecycle.LiveData
import com.example.cs330_pz_3929.data.kolekcija.dao.ScoreDao
import com.example.cs330_pz_3929.data.kolekcija.entity.Score
import javax.inject.Inject

class ScoreRepository @Inject constructor(private val scoreDao: ScoreDao) {
    fun getAllScores(): LiveData<List<Score>> = scoreDao.getAllScores()

    suspend fun insert(score: Score) {
        scoreDao.insert(score)
    }
}