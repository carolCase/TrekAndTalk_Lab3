package com.example.trekandtalk_lab3.data.uistates

data class SignUpUIState(
    var userName: String = "",
    var email:String = "",
    var password:String="",

    var userNameError:Boolean = false,
    var emailError:Boolean = false,
    var passwordError : Boolean = false


)
