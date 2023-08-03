package com.example.todoapp.task

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.todoapp.auth.ButtonClickOn


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(navController: NavHostController) {
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        ) {
        OutlinedTextField(
            value = firstName,
            label = { Text(text = "First Name")},
            modifier = Modifier.padding(top = 30.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor= Color.Black,
            ),
            onValueChange ={
            firstName = it
            }
        )
        OutlinedTextField(
            value = lastName,
            label = { Text(text = "Last Name")},
            modifier = Modifier.padding(top = 30.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor= Color.Black,
            ),
            onValueChange ={
            lastName = it
            }
        )
        OutlinedTextField(
            value = email,
            label = { Text(text = "Email")},
            modifier = Modifier.padding(top = 30.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor= Color.Black,
            ),
            onValueChange ={
                email = it
            },
        )
        OutlinedTextField(
            value = age,
            label = { Text(text = "Age")},
            modifier = Modifier.padding(top = 30.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor= Color.Black,
            ),
            onValueChange ={
                age = it
            },
        )

        ButtonClickOn("Register",30){
            navController.navigate("home/$firstName/$lastName/$email/$age")
        }

    }
}