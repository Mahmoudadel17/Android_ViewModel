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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.todoapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavHostController) {
    val context = LocalContext.current
    var userName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var userNameErrorMessage by remember { mutableStateOf("") }
    var emailErrorMessage by remember { mutableStateOf("") }
    var passwordErrorMessage by remember { mutableStateOf("") }

    var showPassword by remember { mutableStateOf(false) }
    var checkBox by remember { mutableStateOf(false) }

    var isErrorUserName by remember { mutableStateOf(false) }
    var isErrorEmail by remember { mutableStateOf(false) }
    var isErrorPassword by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Box(modifier = Modifier.size(250.dp)) {
            LoaderAnimation(R.raw.signup)
        }
        OutlinedTextField(
            label = { Text("UserName",style = TextStyle(color = Color.DarkGray)) },
            value = userName,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = {
                userName = it
                userNameErrorMessage = ""
                isErrorUserName = false

            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor= Color.Black,
                errorTextColor = Color.Black,
            ),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            isError = isErrorUserName,
            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.baseline_person_24),
                    contentDescription = " ", tint=Color.DarkGray )
            }
        )
       Row {
           Text(
               text = userNameErrorMessage, style = MaterialTheme.typography.bodyMedium, modifier = Modifier
                   .padding(top = 3.dp, start = 25.dp), color = Color.Red
           )
           Spacer(modifier = Modifier.weight(1f))
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
           Text(text = emailErrorMessage, style = MaterialTheme.typography.bodyMedium, modifier = Modifier
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
                focusedTextColor = Color.Black,
                errorTextColor = Color.Black,
            ),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 3.dp),
            trailingIcon = {
                IconButton(onClick = {
                    showPassword = showPassword.not()
                }) {
                    Icon(painter = painterResource(id = if(showPassword) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24),
                        contentDescription = " ", tint=Color.DarkGray )                }
            }
        )
       Row {
           Text(
               passwordErrorMessage, style = MaterialTheme.typography.bodyMedium, modifier = Modifier
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
        ButtonClickOn("Sign Up",30) {
            val validationAuthBack = validationSignUp(userName,email, password)
            userNameErrorMessage = validationAuthBack.userNameErrorMessage
            emailErrorMessage = validationAuthBack.emailErrorMessage
            passwordErrorMessage = validationAuthBack.passwordErrorMessage
            isErrorUserName = validationAuthBack.nameValid.not()
            isErrorEmail = validationAuthBack.emailValid.not()
            isErrorPassword = validationAuthBack.passwordValid.not()
            if (validationAuthBack.nameValid && validationAuthBack.emailValid && validationAuthBack.passwordValid) {
                if (checkBox) {
                    Toast.makeText(context, "Login successful! Remember", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT).show()
                }
                navController.navigate("home")

            }
        }

        Row{
            Text(
                text ="You already registered?",
                modifier = Modifier
                    .padding(top = 3.dp, start = 25.dp),
                color = Color.DarkGray,
                fontSize = 12.sp,
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                "Login",
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .padding(top = 3.dp)
                    .clickable {
                        navController.navigate("login")
                    },
                color = Color.DarkGray,
                fontSize = 12.sp,
            )
            Spacer(modifier = Modifier.weight(1f))

        }
    }
}

