package com.example.cs330_pz_3929.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cs330_pz_3929.data.kolekcija.entity.Score
import com.example.cs330_pz_3929.ui.viewmodel.ScoresViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ScoresScreen(navController: NavHostController, viewModel: ScoresViewModel) {
    // Remember for local state
    val scores = remember { mutableStateOf<List<Score>>(emptyList()) }
    var showScores by remember { mutableStateOf(false) }

    // Observe scores from ViewModel
    LaunchedEffect(viewModel) {
        viewModel.allScores.observeForever { updatedScores ->
            scores.value = updatedScores
            showScores = true
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

        // AnimatedVisibility for animated display of the scores list
        AnimatedVisibility(
            visible = showScores,
            enter = slideInVertically(
                initialOffsetY = { -it },
                animationSpec = tween(durationMillis = 500)
            ),
            exit = slideOutVertically(
                targetOffsetY = { -it },
                animationSpec = tween(durationMillis = 500)
            )
        ) {
            Column {
                scores.value.forEach { score ->
                    Text("${score.playerName}: ${score.score} points")
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("home") }) {
            Text("Back to Home")
        }
    }
}