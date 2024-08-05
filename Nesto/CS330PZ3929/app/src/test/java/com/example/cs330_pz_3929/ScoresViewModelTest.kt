package com.example.cs330_pz_3929

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cs330_pz_3929.Entity.Score

import com.example.cs330_pz_3929.Repository.ScoreRepository
import com.example.cs330_pz_3929.ViewModel.ScoresViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ScoresViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var scoresViewModel: ScoresViewModel
    private lateinit var scoreRepository: ScoreRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        scoreRepository = mock()
        scoresViewModel = ScoresViewModel(mock())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun testGetAllScores() = runBlockingTest {
        val scoreList = listOf(Score(1, "Player1", 100), Score(2, "Player2", 200))
        val liveData = MutableLiveData<List<Score>>()
        liveData.value = scoreList

        whenever(scoreRepository.getAllScores()).thenReturn(liveData)

        val observer: Observer<List<Score>> = mock()
        scoresViewModel.allScores.observeForever(observer)

        verify(observer).onChanged(scoreList)
    }

    @Test
    fun testInsertScore() = runBlockingTest {
        val score = Score(0, "Player3", 300)
        scoresViewModel.insertScore(score)
        verify(scoreRepository).insert(score)
    }
}