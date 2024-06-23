package com.example.cs330_pz_3929

import android.app.Application
import org.junit.Assert.assertEquals
import org.junit.Test

class GameViewModelTest {


    @Test
    fun testScoreCalculation() {

        val viewModel = GameViewModel(mockApplication)


        viewModel.incrementScore()
        viewModel.incrementScore()
        viewModel.incrementScore()


        assertEquals(3, viewModel.currentScore)
    }


    private val mockApplication = androidx.test.core.app.ApplicationProvider.getApplicationContext<MyApplication>()
}


class GameViewModel(private val application: Application) {
    var currentScore = 0

    fun incrementScore() {
        currentScore++
    }

    fun saveScore(playerName: String, score: Int) {

    }
}


class MyApplication : Application()