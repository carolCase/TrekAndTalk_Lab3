package com.example.trekandtalk_lab3.data.uievents

sealed class SignUpUIEvent {
    data class UserNameChanged(val userName:String):SignUpUIEvent()
    data class EmailChanged(val email:String):SignUpUIEvent()
    data class PasswordChanged(val password:String):SignUpUIEvent()

data object RegisterButton: SignUpUIEvent()

}