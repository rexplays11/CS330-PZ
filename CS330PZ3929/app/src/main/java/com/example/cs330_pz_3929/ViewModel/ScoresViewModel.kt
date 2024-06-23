package com.example.cs330_pz_3929.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cs330_pz_3929.Database.AppDatabase
import com.example.cs330_pz_3929.Entity.Score
import com.example.cs330_pz_3929.Repository.ScoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScoresViewModel(application: Application) : AndroidViewModel(application) {

    private val scoreRepository: ScoreRepository


    val allScores: LiveData<List<Score>>

    init {
        val scoreDao = AppDatabase.getDatabase(application).scoreDao()
        scoreRepository = ScoreRepository(scoreDao)
        allScores = scoreRepository.getAllScores()
    }


    fun insertScore(score: Score) = viewModelScope.launch(Dispatchers.IO) {
        scoreRepository.insert(score)
    }
}