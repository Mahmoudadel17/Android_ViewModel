package com.example.todoapp.navigation

sealed class Screens(val route:String){
    object LoginScreen:Screens(route = "login")
    object SignUpScreen:Screens(route = "signUp")
    object AuthRoute:Screens(route = "auth")
    object HomeRoute:Screens(route = "navigationHome")

    object AppNavigation:Screens(route = "appNavigation")
    object GymScreen:Screens(route = "gym")
}
