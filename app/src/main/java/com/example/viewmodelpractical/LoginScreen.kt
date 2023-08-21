package com.example.viewmodelpractical



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun LoginScreen() {
    val viewModel:LoginViewModel = viewModel()
    val state = viewModel.state
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize()
    ) {
        LottieAnimationShow(R.raw.login,200,0)
        EmailEditText(
            email = state.value.email,
            isErrorEmail = state.value.isErrorEmail,
            emailErrorMessage = state.value.emailErrorMessage,
            onValueChange = {viewModel.onEmailChange(it)}
        )
        PasswordEditText(
            password = state.value.password,
            isErrorPassword = state.value.isErrorPassword,
            passwordErrorMessage = state.value.passwordErrorMessage,
            showPassword = state.value.showPassword,
            onValueChange = {viewModel.onPasswordChange(it)}
        ) {
            viewModel.onIconButtonClick()
        }
        CheckBox(text = "Remember Me", checkBox = state.value.checkBox) {
            viewModel.onCheckBoxClick()
        }
        ButtonClickOn(buttonText = "Login", paddingValue = 120) {
            viewModel.onLoginButtonClick()
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
                    .padding(top = 3.dp),
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
                        // go to forgot password screen
                    },
                color = Color.DarkGray,
                fontSize = 12.sp,
            )
        }

    }
}