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
import com.example.cs330_pz_3929.API.ApiService
import com.example.cs330_pz_3929.ViewModel.GameViewModel
import com.example.cs330_pz_3929.getViewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random
@Composable
fun GameScreen(
    navController: NavHostController,
    shapeDisappearTime: Long,
    shapeSize: Int,
    viewModel: GameViewModel = viewModel(factory = getViewModelFactory())
) {
    var score by remember { mutableStateOf(0) }
    val gameDuration = 30000L // 30 sekundi
    val shapes = remember { mutableStateListOf<Shape>() }
    val coroutineScope = rememberCoroutineScope()
    val maxShapes = 7
    var showDialog by remember { mutableStateOf(false) }
    var playerName by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        val startTime = System.currentTimeMillis() // cuva vreme kada je pocela igra
        while (System.currentTimeMillis() - startTime < gameDuration) {
            val numberOfShapes = Random.nextInt(1, maxShapes + 1) // Generisanje nasumicnog broja oblika, krugova.
            shapes.clear()
            repeat(numberOfShapes) {
                shapes.add(
                    Shape(
                        x = Random.nextFloat() * (300 - shapeSize),
                        y = Random.nextFloat() * (500 - shapeSize)
                    )
                )
            }
            delay(shapeDisappearTime)
        }
        showDialog = true
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // za prikazivanje trenutnog rezultata.
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text("Score: $score", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        }
        Box(
            modifier = Modifier.weight(1f)
        ) {
            shapes.forEach { shape ->
                Box(
                    modifier = Modifier
                        .offset(x = shape.x.dp, y = shape.y.dp)
                        .size(shapeSize.dp)
                        .background(Color.Red, shape = CircleShape)
                        .clickable {
                            score += 1
                            shapes.remove(shape)
                        }
                )
            }
        }
        Button(onClick = { navController.navigate("home") }) {
            Text("Back to Home")
        }
    }
    // AlertDialog koji se prikazuje kada igra završi.
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text("Game Over") },
            text = {
                Column {
                    Text("Your Score: $score")
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = playerName,
                        onValueChange = { playerName = it },
                        label = { Text("Enter your name") }
                    )
                }
            },
            confirmButton = {
                Button(onClick = {
                    viewModel.saveScore(playerName, score)
                    navController.navigate("scores")
                }) {
                    Text("Submit Score")
                }
            },
            dismissButton = {
                Column {
                    Button(onClick = {
                        navController.navigate("game")
                    }) {
                        Text("Play Again")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        navController.navigate("home")
                    }) {
                        Text("Back to Home")
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = {
                        coroutineScope.launch {
                            try {
                                val randomUserId = Random.nextInt(1, 11) // ID između 1 i 10
                                val user = viewModel.apiService.getUser(randomUserId)
                                playerName = user.username
                            } catch (e: Exception) {
                                // Handle error
                            }
                        }
                    }) {
                        Text("Fetch Random Username")
                    }
                }
            },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        )
    }
}
data class Shape(val x: Float, val y: Float)

