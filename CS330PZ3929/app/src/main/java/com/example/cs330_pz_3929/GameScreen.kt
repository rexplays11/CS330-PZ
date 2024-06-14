package com.example.cs330_pz_3929


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun GameScreen(navController: NavHostController, shapeDisappearTime: Long, shapeSize: Int) {
    var score by remember { mutableIntStateOf(0) }
    val gameDuration = 30000L // 30 sekundi
    val shapes = remember { mutableStateListOf<Shape>() }
    val coroutineScope = rememberCoroutineScope()
    val maxShapes = 7

    LaunchedEffect(Unit) {
        val startTime = System.currentTimeMillis()
        while (System.currentTimeMillis() - startTime < gameDuration) {
            val numberOfShapes = Random.nextInt(1, maxShapes + 1)

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
}
data class Shape(val x: Float, val y: Float)
