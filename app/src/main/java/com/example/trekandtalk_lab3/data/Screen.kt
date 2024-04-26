package com.example.trekandtalk_lab3.data

sealed class Screen {
    data object WelcomeScreen : Screen()
    data object SignUpScreen : Screen()
    data object LoginScreen : Screen()


}