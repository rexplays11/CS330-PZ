package com.example.cs330_pz_3929


import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import kotlin.random.Random

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicijalizacija ViewModel-a
        val gameViewModel: GameViewModel by viewModels()
        val scoresViewModel: ScoresViewModel by viewModels()

        setContent {
            val navController = rememberNavController()
            var speed by remember { mutableStateOf(1000L) }
            var size by remember { mutableStateOf(30) }

            // Povezivanje NavHost-a s Composable funkcijama
            NavHost(navController, startDestination = "home") {
                composable("home") { HomeScreen(navController) }
                composable("settings") {
                    SettingsScreen(navController, speed, size) { newSpeed, newSize ->
                        speed = newSpeed
                        size = newSize
                    }
                }
                composable("game") { GameScreen(navController, speed, size, gameViewModel) }
                composable("scores") { ScoresScreen(navController,scoresViewModel) }
            }
        }
    }
}