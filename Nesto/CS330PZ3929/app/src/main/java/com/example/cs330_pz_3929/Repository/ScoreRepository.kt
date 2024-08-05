package com.example.cs330_pz_3929.Repository

import androidx.lifecycle.LiveData
import com.example.cs330_pz_3929.DAO.ScoreDao
import com.example.cs330_pz_3929.Entity.Score


//Klasa ScoreRepository služi kao posrednik između ScoreDao i ViewModel-a
class ScoreRepository(private val scoreDao: ScoreDao) {
    // Metoda koja vraća sve rezultate (score-ove) kao LiveData listu.
    // Poziva odgovarajuću metodu iz ScoreDao.
    fun getAllScores(): LiveData<List<Score>> = scoreDao.getAllScores()

    suspend fun insert(score: Score) {
        scoreDao.insert(score)
    }
}