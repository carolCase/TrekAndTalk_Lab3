package com.example.trekandtalk_lab3.data.uistates

import com.google.firebase.firestore.auth.User

data class LoginUIState(


    var email:String = "",
    var password:String="",



    var emailError:Boolean = false,
    var passwordError : Boolean = false
)