package com.example.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.todoapp.androidCookies.GymsScreen
import com.example.todoapp.bottomNav.AccountScreen
import com.example.todoapp.bottomNav.HomeScreen
import com.example.todoapp.bottomNav.MyApp
import com.example.todoapp.bottomNav.SearchScreen
import com.example.todoapp.bottomNav.SettingsScreen

fun NavGraphBuilder.bottomNav(navController: NavHostController) {
    navigation(startDestination = Screens.AppNavigation.route,route= Screens.HomeRoute.route){

        composable(route = Screens.AppNavigation.route){
            MyApp(navController)
        }
        composable(route = Screens.GymScreen.route){
            GymsScreen()
        }


    }
}


@Composable
fun bottomNav(navController: NavHostController,navController2: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationScreens.Home.route){
        composable(route = NavigationScreens.Home.route){
            HomeScreen(navController2)
        }
        composable(route = NavigationScreens.Account.route){
            AccountScreen(navController2)
        }
        composable(route = NavigationScreens.Search.route){
            SearchScreen(navController2)
        }
        composable(route = NavigationScreens.Settings.route){
            SettingsScreen(navController2)
        }

    }
}

