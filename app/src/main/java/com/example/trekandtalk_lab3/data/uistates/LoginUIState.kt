package com.example.trekandtalk_lab3.data.uistates

data class LoginUIState(


    var email:String = "",
    var password:String="",


    var emailError:Boolean = false,
    var passwordError : Boolean = false
)