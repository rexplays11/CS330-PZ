package com.example.cs330_pz_3929

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import com.example.cs330_pz_3929.API.ApiService
import com.example.cs330_pz_3929.Database.AppDatabase
import com.example.cs330_pz_3929.Entity.Score

import com.example.cs330_pz_3929.DAO.ScoreDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.advanceUntilIdle
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mockito.*

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random
import androidx.room.Room
import com.example.cs330_pz_3929.API.User2
import com.example.cs330_pz_3929.ViewModel.GameViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.robolectric.RobolectricTestRunner

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
class GameViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var viewModel: GameViewModel
    private lateinit var apiService: ApiService
    private lateinit var database: AppDatabase
    private lateinit var scoreDao: ScoreDao

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        val application = ApplicationProvider.getApplicationContext<Application>()
        apiService = Mockito.mock(ApiService::class.java)
        database = Room.inMemoryDatabaseBuilder(application, AppDatabase::class.java).allowMainThreadQueries().build()
        scoreDao = database.scoreDao()
        viewModel = GameViewModel(application).apply {
             retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            apiService = retrofit.create(ApiService::class.java)
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        database.close()
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun testIncrementScore() {
        val initialScore = viewModel.score
        viewModel.incrementScore()
        Assert.assertEquals(initialScore + 1, viewModel.score)
    }

    @Test
    fun testResetGame() {
        viewModel.incrementScore()
        viewModel.resetGame()
        Assert.assertEquals(0, viewModel.score)
        Assert.assertTrue(viewModel.shapes.isEmpty())
        Assert.assertFalse(viewModel.showDialog)
    }

    @Test
    fun testStartGame() = testScope.runBlockingTest {
        viewModel.startGame(1000L, 50)
        advanceUntilIdle()
        Assert.assertTrue(viewModel.shapes.isNotEmpty())
        Assert.assertTrue(viewModel.showDialog)
    }

    @Test
    fun testFetchRandomUsername() = testScope.runBlockingTest {
        val user = User2(1, "mockUser")
        `when`(apiService.getUser(anyInt())).thenReturn(user)

        viewModel.fetchRandomUsername()
        advanceUntilIdle() // Ceka da se pozove API
        Assert.assertEquals("mockUser", viewModel.playerName)
    }

    @Test
    fun testSaveScore() = testScope.runBlockingTest {
        val score = Score(playerName = "Player1", score = 10)
        viewModel.saveScore(score.playerName, score.score)

        advanceUntilIdle() // Ceka da se zavrsi proces
        val scores = scoreDao.getAllScores().value ?: emptyList()
        Assert.assertTrue(scores.any { it.playerName == score.playerName && it.score == score.score })
    }
}