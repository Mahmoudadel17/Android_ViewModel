package com.example.todoapp.bottomNav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.todoapp.navigation.Screens


@Composable
fun HomeScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Home", fontSize = 30.sp , color = Color.Black, modifier = Modifier.padding(5.dp))
        Button(onClick = { navController.navigate(Screens.GymScreen.route) }) {
            Text(text = "Go To Page1")
        }
        Button(onClick = {navController.navigate(Screens.GymScreen.route)}) {
            Text(text = "Go To Page2")
        }

    }


}


