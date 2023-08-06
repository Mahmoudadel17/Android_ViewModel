package com.example.todoapp.auth

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todoapp.R
import com.example.todoapp.navigation.NavigationScreens
import com.example.todoapp.navigation.Screens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var emailErrorMessage by remember { mutableStateOf("") }
    var passwordErrorMessage by remember { mutableStateOf("") }

    var showPassword by remember { mutableStateOf(false) }
    var checkBox by remember { mutableStateOf(false) }

    var isErrorEmail by remember { mutableStateOf(false) }
    var isErrorPassword by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Box(modifier = Modifier.size(250.dp)) {
            LoaderAnimation(R.raw.login)
        }
        OutlinedTextField(
            label = { Text("Email",style = TextStyle(color = Color.DarkGray)) },
            value = email,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = {
                email = it
                emailErrorMessage = ""
                isErrorEmail = false

            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor= Color.Black,
                errorTextColor = Color.Black,
            ),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth(),
            isError = isErrorEmail,
            trailingIcon = {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "",tint=Color.DarkGray)
            }
        )
        Row {
            Text(
                emailErrorMessage, style = typography.bodyMedium, modifier = Modifier
                    .padding(top = 3.dp, start = 25.dp), color = Color.Red
            )
            Spacer(modifier = Modifier.weight(1f))

        }


        OutlinedTextField(
            label = { Text("Password",style = TextStyle(color = Color.DarkGray)) },
            value = password,
            isError = isErrorPassword,
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            onValueChange = {
                password = it
                passwordErrorMessage = ""
                isErrorPassword = false
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor= Color.Black,
                errorTextColor = Color.Black,
            ),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            trailingIcon = {
                IconButton(onClick = {
                    showPassword = showPassword.not()
                }) {
                    Icon(painter = painterResource(id = if(showPassword) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24),
                        contentDescription = " ", tint=Color.DarkGray )
                    //Icon(imageVector = Icons.Filled.Lock, contentDescription = "",tint=Color.DarkGray)
                }
            }
        )
        Row {
            Text(
                passwordErrorMessage, style = typography.bodyMedium, modifier = Modifier
                    .padding(top = 3.dp, start = 25.dp), color = Color.Red
            )
            Spacer(modifier = Modifier.weight(1f))

        }


        Row(
           modifier = Modifier.padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = checkBox, onCheckedChange = {
                checkBox = !checkBox
            })
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                "Remember",
                color = Color.DarkGray,
            )
            Spacer(modifier = Modifier.weight(1f))

        }
        ButtonClickOn("Login",100) {
            val validationAuthBack = validationLogin(email, password)
            emailErrorMessage = validationAuthBack.emailErrorMessage
            passwordErrorMessage = validationAuthBack.passwordErrorMessage
            isErrorEmail = validationAuthBack.emailValid.not()
            isErrorPassword = validationAuthBack.passwordValid.not()
            if (validationAuthBack.emailValid && validationAuthBack.passwordValid) {
                if (checkBox) {
                    Toast.makeText(context, "Login successful! Remember", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT).show()
                }
                navController.navigate(Screens.HomeRoute.route)
            }

        }
        Row() {
            Text(
                text ="New to the app?",
                modifier = Modifier
                    .padding(top = 3.dp),
                color = Color.DarkGray,
                fontSize = 12.sp,
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                "Register",
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .padding(top = 3.dp)
                    .clickable {
                        navController.navigate(Screens.SignUpScreen.route)
                    },
                color = Color.DarkGray,
                fontSize = 12.sp,
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                "Forgot Password?",
                textDecoration = TextDecoration.Underline,
                modifier = Modifier

                    .padding(top = 3.dp)
                    .clickable {

                    },
                color = Color.DarkGray,
                fontSize = 12.sp,
            )
        }

    }
}

