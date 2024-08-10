package com.example.cs330_pz_3929


import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.runtime.remember
import com.example.cs330_pz_3929.Screens.GameScreen
import com.example.cs330_pz_3929.Screens.HomeScreen
import com.example.cs330_pz_3929.Screens.ScoresScreen
import com.example.cs330_pz_3929.Screens.SettingsScreen
import com.example.cs330_pz_3929.ViewModel.GameViewModel
import com.example.cs330_pz_3929.ViewModel.ScoresViewModel
import com.example.cs330_pz_3929.ViewModel.SettingsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicijalizacija ViewModel-a
        val gameViewModel: GameViewModel by viewModels()
        val scoresViewModel: ScoresViewModel by viewModels()
        val settingsViewModel: SettingsViewModel by viewModels()

        setContent {
            val navController = rememberNavController()

            // Prikupljanje vrednosti iz SettingsViewModel-a
            val speed by settingsViewModel.speed.collectAsState()
            val size by settingsViewModel.size.collectAsState()

            // Povezivanje NavHost-a s Composable funkcijama
            NavHost(navController, startDestination = "home") {
                composable("home") { HomeScreen(navController) }
                composable("settings") {
                    SettingsScreen(
                        navController,
                        speed,
                        size
                    ) { newSpeed, newSize ->
                        settingsViewModel.updateSpeed(newSpeed)
                        settingsViewModel.updateSize(newSize)
                    }
                }
                composable("game") {
                    GameScreen(navController, speed, size, gameViewModel)
                }
                composable("scores") { ScoresScreen(navController, scoresViewModel) }
            }
        }
    }
}