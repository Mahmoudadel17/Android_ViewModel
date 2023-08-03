package com.example.todoapp.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition


fun validationSignUp(userName:String,email:String,password:String):ValidationAuth{
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


fun validationLogin(email:String,password:String): ValidationAuth{
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
            .padding(8.dp, top =paddingValue.dp)
            .fillMaxWidth(1f)


    ){
        Text(text = buttonText, fontSize = 30.sp, style = TextStyle(color = MaterialTheme.colorScheme.background))
    }
}

