package com.example.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigate() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.AuthRoute.route){
        authNav(navController)
        bottomNav(navController)
    }
}

