package com.example.todoapp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.todoapp.auth.LoginScreen
import com.example.todoapp.auth.SignUpScreen


fun NavGraphBuilder.authNav(navController: NavController){
    navigation(startDestination = Screens.LoginScreen.route,route=Screens.AuthRoute.route){
        composable(route = Screens.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screens.SignUpScreen.route){
            SignUpScreen(navController = navController)
        }


    }
}