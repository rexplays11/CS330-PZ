package com.example.cs330_pz_3929

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cs330_pz_3929.ui.viewmodel.SettingsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.Assert.*

@OptIn(ExperimentalCoroutinesApi::class)
class SettingsViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var settingsViewModel: SettingsViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        settingsViewModel = SettingsViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun updateSpeed_changesSpeed() = runTest {
        val newSpeed = 1500L

        settingsViewModel.updateSpeed(newSpeed)

        assertEquals(newSpeed, settingsViewModel.speed.first())
    }

    @Test
    fun updateSize_changesSize() = runTest {
        val newSize = 50

        settingsViewModel.updateSize(newSize)

        assertEquals(newSize, settingsViewModel.size.first())
    }

    @Test
    fun saveSettings_invokesOnSaveWithCorrectValues() = runTest {
        val newSpeed = 1500L
        val newSize = 50
        settingsViewModel.updateSpeed(newSpeed)
        settingsViewModel.updateSize(newSize)

        var savedSpeed: Long? = null
        var savedSize: Int? = null
        val onSave: (Long, Int) -> Unit = { speed, size ->
            savedSpeed = speed
            savedSize = size
        }

        settingsViewModel.saveSettings(onSave)

        advanceUntilIdle()

        assertEquals(newSpeed, savedSpeed)
        assertEquals(newSize, savedSize)
    }
}