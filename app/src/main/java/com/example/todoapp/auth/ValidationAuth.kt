package com.example.todoapp.auth

data class ValidationAuth(
    var nameValid:Boolean = false,
    var userNameErrorMessage:String = "",
    var emailValid:Boolean = false,
    var emailErrorMessage:String = "",
    var passwordValid:Boolean = false,
    var passwordErrorMessage:String = "")
