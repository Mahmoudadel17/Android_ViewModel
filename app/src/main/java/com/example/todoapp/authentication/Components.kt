package com.example.todoapp.authentication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import com.example.todoapp.auth.ValidationAuth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.todoapp.R
import java.nio.file.attribute.UserDefinedFileAttributeView


fun validationSignUp(userName:String,email:String,password:String): ValidationAuth {
    var errorUserName = ""
    var nameValid = true
    if (userName.isEmpty()){
        errorUserName = "Please enter your Name*"
        nameValid = false
    }
    val checkEmailAndPassword = validationLogin(email, password)
    return ValidationAuth(
        nameValid = nameValid,
        userNameErrorMessage = errorUserName,
        emailValid = checkEmailAndPassword.emailValid,
        emailErrorMessage = checkEmailAndPassword.emailErrorMessage,
        passwordValid = checkEmailAndPassword.passwordValid,
        passwordErrorMessage = checkEmailAndPassword.passwordErrorMessage)

}


fun validationLogin(email:String,password:String): ValidationAuth {
    var errorEmail = ""
    var errorPassword = ""
    var emailvalid = true
    var passwordvalid = true

    if (email.isEmpty()){
        errorEmail = "Please enter your email*"
        emailvalid = false
    }else{
        if(!isValidEmail(email) ){
            errorEmail = "Please enter valid email*"
            emailvalid = false

        }
    }

    if(password.isEmpty()){
        errorPassword = "Please enter your password*"
        passwordvalid = false
    }else{
        if (password.length<8){
            errorPassword = "Please enter valid password (>8 char)*"
            passwordvalid = false
        }
    }
    return ValidationAuth(emailValid = emailvalid, emailErrorMessage = errorEmail, passwordValid = passwordvalid, passwordErrorMessage = errorPassword)
}

fun isValidEmail(email: String): Boolean {
    // Regular expression pattern to validate the email format
    val pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    // Check if the provided email matches the pattern
    return email.matches(Regex(pattern))
}





@Composable
fun LoaderAnimation(animation:Int) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animation))
    LottieAnimation(composition = composition, isPlaying = true)
}

@Composable
fun ButtonClickOn(buttonText:String,paddingValue:Int ,onButtonClick:() -> Unit ) {
    Button (colors = ButtonDefaults.buttonColors(containerColor =MaterialTheme.colorScheme.primary),
        enabled = true,
        onClick = {onButtonClick()},
        modifier = Modifier
            .padding(8.dp, top = paddingValue.dp)
            .fillMaxWidth(1f)

    ){
        Text(text = buttonText, fontSize = 30.sp, style = TextStyle(color = MaterialTheme.colorScheme.background))
    }
}
@Composable
fun CheckBox(checkBox:Boolean,onCheckedChange:() -> Unit) {
    Row(
        modifier = Modifier.padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checkBox, onCheckedChange = {
            onCheckedChange()
        })
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            "Remember",
            color = Color.DarkGray,
        )
        Spacer(modifier = Modifier.weight(1f))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailEditText(
    email:String = "",
    isErrorEmail:Boolean = false,
    emailErrorMessage:String = "",
    onValueChange:(String) -> Unit) {
    OutlinedTextField(
        label = { Text("Email",style = TextStyle(color = Color.DarkGray)) },
        value = email,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        onValueChange = {
            onValueChange(it)

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
            Icon(imageVector = Icons.Filled.Email, contentDescription = "",tint= Color.DarkGray)
        }
    )
    Row {
        Text(
            emailErrorMessage, style = MaterialTheme.typography.bodyMedium, modifier = Modifier
                .padding(top = 3.dp, start = 25.dp), color = Color.Red
        )
        Spacer(modifier = Modifier.weight(1f))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordEditText(
    password:String = "",
    isErrorPassword:Boolean = false,
    passwordErrorMessage:String = "",
    showPassword:Boolean=false,
    onValueChange:(String) -> Unit,
    onIconButtonClick:() -> Unit
) {
    OutlinedTextField(
        label = { Text("Password",style = TextStyle(color = Color.DarkGray)) },
        value = password,
        isError = isErrorPassword,
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        onValueChange = {
            onValueChange(it)
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
                onIconButtonClick()
            }) {
                Icon(painter = painterResource(id = if(showPassword) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24),
                    contentDescription = " ", tint=Color.DarkGray )
                //Icon(imageVector = Icons.Filled.Lock, contentDescription = "",tint=Color.DarkGray)
            }
        }
    )
    Row {
        Text(
            passwordErrorMessage, style = MaterialTheme.typography.bodyMedium, modifier = Modifier
                .padding(top = 3.dp, start = 25.dp), color = Color.Red
        )
        Spacer(modifier = Modifier.weight(1f))

    }

}

@Composable
fun Animation(animation: Int, size: Int) {
    Box(modifier = Modifier.size(size.dp)) {
        LoaderAnimation(animation = animation)
    }
}


