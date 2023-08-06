package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.auth.LoginScreen
import com.example.todoapp.auth.SignUpScreen
import com.example.todoapp.navigation.Navigate
import com.example.todoapp.navigation.NavigationScreens
import com.example.todoapp.ui.theme.ToDoAppTheme
import androidx.compose.material.*
import androidx.navigation.NavGraph.Companion.findStartDestination


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                //GymsScreen()
                Navigate()

//                NavHost(navController = navController, startDestination = "register" ){
//                    composable("home/{firstName}/{lastName}/{email}/{age}",
//                        arguments = listOf(
//                            navArgument("firstName") { type = NavType.StringType },
//                            navArgument("lastName") { type = NavType.StringType },
//                            navArgument("email") { type = NavType.StringType },
//                            navArgument("age") { type = NavType.StringType }
//                        )
//
//
//                    ) {
//                        val firstName = it.arguments?.getString("firstName") ?: ""
//                        val lastName = it.arguments?.getString("lastName") ?: ""
//                        val email = it.arguments?.getString("email") ?: ""
//                        val age = it.arguments?.getString("age") ?: "0"
//                        HomeRegister(firstName,lastName,email,age)
//                    }
//                    composable("register"){
//                        Register(navController)
//                    }
//
//                }



            }
        }
    }
}

