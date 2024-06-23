package com.example.cs330_pz_3929.Screens


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.*

import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cs330_pz_3929.Entity.Score
import com.example.cs330_pz_3929.ViewModel.ScoresViewModel


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ScoresScreen(navController: NavHostController, viewModel: ScoresViewModel) {
    // Za čuvanje liste rezultata sa mogućnošću promene.
    val scores = remember { mutableStateOf<List<Score>>(emptyList()) }
    var showScores by remember { mutableStateOf(false) }

    // Posmatra promene u listi rezultata i ažurira stanje kada se rezultati promene.
    LaunchedEffect(true) {
        viewModel.allScores.observeForever { updatedScores ->
            scores.value = updatedScores
            showScores = true // Postavljamo da prikaže score-ove kada se ažuriraju
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

        // AnimatedVisibility za animirano prikazivanje liste rezultata.
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
            // Column za prikazivanje svakog rezultata sa razmakom između njih.
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