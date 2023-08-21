package com.example.viewmodelpractical

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
   private var _state by mutableStateOf(
        LoginScreenState(
            email = "",
            isErrorEmail = false,
            emailErrorMessage = "",
            password = "",
            isErrorPassword = false,
            passwordErrorMessage = "",
            showPassword = false,
            checkBox = false
        )
    )

    val state: State<LoginScreenState>
            get() = derivedStateOf { _state }





    fun onEmailChange(email:String){
        _state = _state.copy(
            email = email,
            isErrorEmail = false,
            emailErrorMessage = ""
            )
    }

    fun onPasswordChange(password:String){
        _state = _state.copy(
            password = password,
            isErrorPassword = false,
            passwordErrorMessage = ""
        )

    }




    fun onCheckBoxClick(){
        val newValue = _state.checkBox.not()
       _state = _state.copy(
           checkBox = newValue
       )
    }
    fun onIconButtonClick(){
        val newShowPassword = _state.showPassword.not()
        _state = _state.copy(
            showPassword = newShowPassword
        )
    }
    fun onLoginButtonClick() {
        if (_state.email.isEmpty()){
            _state=_state.copy(
                isErrorEmail = true,
                emailErrorMessage = "Please enter your email"
            )

        }
        if (_state.password.isEmpty()){
            _state=_state.copy(
                isErrorPassword = true,
                passwordErrorMessage = "Please enter your password"
            )

        }

    }



}