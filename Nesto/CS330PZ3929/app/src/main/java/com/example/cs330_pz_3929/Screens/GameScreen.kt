package com.example.cs330_pz_3929.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cs330_pz_3929.ViewModel.GameViewModel
import kotlinx.coroutines.launch


@Composable
fun GameScreen(navController: NavHostController, shapeDisappearTime: Long, shapeSize: Int, viewModel: GameViewModel) {
    LaunchedEffect(Unit) {
        viewModel.startGame(shapeDisappearTime, shapeSize)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text("Score: ${viewModel.score}", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        }
        Box(
            modifier = Modifier.weight(1f)
        ) {
            viewModel.shapes.forEach { shape ->
                Box(
                    modifier = Modifier
                        .offset(x = shape.x.dp, y = shape.y.dp)
                        .size(shapeSize.dp)
                        .background(Color.Red, shape = CircleShape)
                        .clickable {
                            viewModel.incrementScore()
                            viewModel.shapes.remove(shape)
                        }
                )
            }
        }
        Button(onClick = { navController.navigate("home") }) {
            Text("Back to Home")
        }
    }
    if (viewModel.showDialog) {
        GameOverDialog(
            score = viewModel.score,
            playerName = viewModel.playerName,
            onPlayerNameChange = { viewModel.playerName = it },
            onSubmitScore = {
                viewModel.saveScore(viewModel.playerName, viewModel.score)
                navController.navigate("scores")
            },
            onPlayAgain = {
                viewModel.resetGame()
                navController.navigate("game")
            },
            onFetchRandomUsername = { viewModel.fetchRandomUsername() },
            onBackToHome = { navController.navigate("home") }
        )
    }
}

@Composable
fun GameOverDialog(
    score: Int,
    playerName: String,
    onPlayerNameChange: (String) -> Unit,
    onSubmitScore: () -> Unit,
    onPlayAgain: () -> Unit,
    onFetchRandomUsername: () -> Unit,
    onBackToHome: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text("Game Over") },
        text = {
            Column {
                Text("Your Score: $score")
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = playerName,
                    onValueChange = onPlayerNameChange,
                    label = { Text("Enter your name") }
                )
            }
        },
        confirmButton = {
            Button(onClick = onSubmitScore) {
                Text("Submit Score")
            }
        },
        dismissButton = {
            Column {
                Button(onClick = onPlayAgain) {
                    Text("Play Again")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = onBackToHome) {
                    Text("Back to Home")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = onFetchRandomUsername) {
                    Text("Fetch Random Username")
                }
            }
        },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    )
}