package com.example.todoapp.navigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
sealed class NavigationScreens(val route:String, val title:String, val icon:ImageVector){
    object Home:NavigationScreens(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Search:NavigationScreens(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )
    object Account:NavigationScreens(
        route = "account",
        title = "Account",
        icon = Icons.Default.AccountBox
    )
    object Settings:NavigationScreens(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )
}


