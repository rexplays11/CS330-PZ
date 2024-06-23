package com.example.cs330_pz_3929.ViewModel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs330_pz_3929.Database.AppDatabase
import com.example.cs330_pz_3929.DAO.ScoreDao
import com.example.cs330_pz_3929.Entity.Score
import kotlinx.coroutines.launch
//Klasa GameViewModel nasleđuje AndroidViewModel i omogućava rad sa podacima u životnom ciklusu aplikacije
class GameViewModel(application: Application) : AndroidViewModel(application) {

    // Inicijalizacija ScoreDao objekta pozivanjem getDatabase metode koja vraća instancu AppDatabase.
    var scoreDao: ScoreDao = AppDatabase.getDatabase(application).scoreDao()

    fun saveScore(playerName: String, score: Int) {
        viewModelScope.launch {
            scoreDao.insert(Score(playerName = playerName, score = score))
        }
    }
}