package com.example.todoapp.bottomNav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.navigation.NavigationScreens
import com.example.todoapp.navigation.bottomNav
import com.example.todoapp.ui.theme.PurpleGrey80
import com.example.todoapp.ui.theme.splash


@Composable
fun MyApp(navHostController: NavHostController){

    val navController = rememberNavController()
    val items = listOf( NavigationScreens.Home , NavigationScreens.Account , NavigationScreens.Search , NavigationScreens.Settings)
    Scaffold(
        bottomBar = {
            BottomNavigation (elevation = 10.dp,backgroundColor = splash){
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                        label = { if(currentRoute == screen.route) Text(text = screen.title) },

                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route){
                                popUpTo(navController.graph.findStartDestination().id){
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        selectedContentColor = PurpleGrey80,
                        unselectedContentColor = Color.Gray,
                        )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(containerColor = PurpleGrey80,onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Add,tint = splash, contentDescription = "Add")
            }
        }


    ) {
        Box(modifier = Modifier.padding(it)){
            bottomNav(navController,navHostController)
        }
    }


}




