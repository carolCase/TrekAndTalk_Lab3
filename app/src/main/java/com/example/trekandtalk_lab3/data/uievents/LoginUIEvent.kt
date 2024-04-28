package com.example.trekandtalk_lab3.data.uievents

 sealed class LoginUIEvent {

    data class EmailChanged(val email:String):LoginUIEvent()
    data class PasswordChanged(val password:String):LoginUIEvent()

    data object LoginButton: LoginUIEvent()


}