package com.example.cs330_pz_3929

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cs330_pz_3929.data.kolekcija.database.AppDatabase
import com.example.cs330_pz_3929.data.kolekcija.repository.ScoreRepository
import com.example.cs330_pz_3929.ui.viewmodel.GameViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class GameViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var db: AppDatabase
    private lateinit var scoreRepository: ScoreRepository
    private lateinit var viewModel: GameViewModel

    @Before
    fun setup() {
        // Kreiranje in-memory baze podataka za testove
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()

        scoreRepository = ScoreRepository(db.scoreDao())

        val application = ApplicationProvider.getApplicationContext<Application>()
        viewModel = GameViewModel(application, scoreRepository)
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun `test incrementScore`() {
        val initialScore = viewModel.score
        viewModel.incrementScore()
        assert(viewModel.score == initialScore + 1)
    }

    @Test
    fun `test resetGame`() {
        viewModel.resetGame()
        assert(viewModel.score == 0)
        assert(viewModel.shapes.isEmpty())
        assert(!viewModel.showDialog)
    }


}