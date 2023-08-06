package com.example.todoapp.authentication

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R
import com.example.todoapp.navigation.Screens


@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Animation(R.raw.login,250)
        //EmailEditText()
        //PasswordEditText()
        //CheckBox()
        //ButtonClickOn()
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
                        //navController.navigate(Screens.SignUpScreen.route)
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
