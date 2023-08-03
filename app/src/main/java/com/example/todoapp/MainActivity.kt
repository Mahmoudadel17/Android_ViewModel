package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todoapp.task.HomeRegister
import com.example.todoapp.task.Register
import com.example.todoapp.ui.theme.ToDoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
//                val navController = rememberNavController()
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
