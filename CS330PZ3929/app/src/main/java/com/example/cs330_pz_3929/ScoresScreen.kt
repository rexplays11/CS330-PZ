package com.example.cs330_pz_3929


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun ScoresScreen(navController: NavHostController, viewModel: ScoresViewModel) {
    val scores = remember { mutableStateOf<List<Score>>(emptyList()) }

    // Effect za dobavljanje score-ova iz ViewModel-a pri prvom renderiranju
    LaunchedEffect(true) {
        viewModel.allScores.observeForever { updatedScores ->
            scores.value = updatedScores
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("High Scores", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        scores.value.forEach { score ->
            Text("${score.playerName}: ${score.score} points")
            Spacer(modifier = Modifier.height(8.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("home") }) {
            Text("Back to Home")
        }
    }
}