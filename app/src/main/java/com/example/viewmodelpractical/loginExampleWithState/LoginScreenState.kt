package com.example.viewmodelpractical.loginExampleWithState

data class LoginScreenState(
    val email:String,
    val isErrorEmail:Boolean,
    val emailErrorMessage:String,

    val password:String,
    val isErrorPassword:Boolean,
    val passwordErrorMessage:String,

    val showPassword:Boolean,
    val checkBox:Boolean
)
