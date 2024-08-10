package com.example.cs330_pz_3929.ui.viewmodel


import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs330_pz_3929.api.ApiService
import com.example.cs330_pz_3929.data.kolekcija.entity.Score
import com.example.cs330_pz_3929.data.kolekcija.repository.ScoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import kotlin.random.Random

data class Shape(val x: Float, val y: Float)

@HiltViewModel
class GameViewModel @Inject constructor(
    application: Application,
    private val scoreRepository: ScoreRepository
) : AndroidViewModel(application) {
    var score by mutableStateOf(0)
    val shapes = mutableStateListOf<Shape>()
    var showDialog by mutableStateOf(false)
    var playerName by mutableStateOf("")
    private val maxShapes = 7
    private val gameDuration = 30000L // 30 sekundi

    fun startGame(shapeDisappearTime: Long, shapeSize: Int) {
        viewModelScope.launch {
            val startTime = System.currentTimeMillis()
            while (System.currentTimeMillis() - startTime < gameDuration) {
                val numberOfShapes = Random.nextInt(1, maxShapes + 1)
                shapes.clear()
                repeat(numberOfShapes) {
                    shapes.add(
                        Shape(
                            x = Random.nextFloat() * (300 - shapeSize),
                            y = Random.nextFloat() * (500 - shapeSize)
                        )
                    )
                }
                delay(shapeDisappearTime)
            }
            showDialog = true
        }
    }

    fun incrementScore() {
        score =score+ 1
    }

    fun resetGame() {
        showDialog = false
        score = 0
        shapes.clear()
        viewModelScope.coroutineContext.cancelChildren()
    }

    var retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var apiService = retrofit.create(ApiService::class.java)

    fun fetchRandomUsername() {
        viewModelScope.launch {
            try {
                val randomUserId = Random.nextInt(1, 11)
                val user = apiService.getUser(randomUserId)
                playerName = user.username
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun saveScore(playerName: String, score: Int) {
        viewModelScope.launch {
            scoreRepository.insert(Score(playerName = playerName, score = score))
        }
    }
}