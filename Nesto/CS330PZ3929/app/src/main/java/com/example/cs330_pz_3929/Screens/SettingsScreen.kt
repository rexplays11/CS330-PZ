package com.example.cs330_pz_3929.Screens
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cs330_pz_3929.ViewModel.SettingsViewModel
@Composable
fun SettingsScreen(
    navController: NavHostController,
    currentSpeed: Long,
    currentSize: Int,
    onSave: (Long, Int) -> Unit
) {
    var speed by remember { mutableStateOf(currentSpeed) }
    var size by remember { mutableStateOf(currentSize) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Settings", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Shape Disappear Speed: $speed ms")
        Slider(
            value = speed.toFloat(),
            onValueChange = { speed = it.toLong() },
            valueRange = 500f..2000f,
            steps = 3
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Shape Size: $size px")
        Slider(
            value = size.toFloat(),
            onValueChange = { size = it.toInt() },
            valueRange = 30f..60f
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            onSave(speed, size)
            navController.navigate("home")
        }) {
            Text("Save")
        }
    }
}