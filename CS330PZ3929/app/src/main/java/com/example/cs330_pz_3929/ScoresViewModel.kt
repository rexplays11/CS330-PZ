package com.example.cs330_pz_3929

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ScoresViewModel(application: Application) : AndroidViewModel(application) {

    private val scoreRepository: ScoreRepository

    // LiveData za prikaz score-ova u ScoresScreen-u
    val allScores: LiveData<List<Score>>

    init {
        val scoreDao = AppDatabase.getDatabase(application).scoreDao()
        scoreRepository = ScoreRepository(scoreDao)
        allScores = scoreRepository.getAllScores()
    }

    // Metoda za dodavanje novog score-a
    fun insertScore(score: Score) = viewModelScope.launch(Dispatchers.IO) {
        scoreRepository.insert(score)
    }
}