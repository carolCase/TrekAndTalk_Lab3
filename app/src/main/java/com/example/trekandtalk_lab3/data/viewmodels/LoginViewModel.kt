package com.example.trekandtalk_lab3.data.viewmodels

import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel
import com.example.trekandtalk_lab3.data.uievents.LoginUIEvent
import com.example.trekandtalk_lab3.data.uistates.LoginUIState

import com.example.trekandtalk_lab3.navigation.Screen
import com.example.trekandtalk_lab3.rules.ErrorHandling
import com.google.firebase.auth.FirebaseAuth



class LoginViewModel:ViewModel() {

    var loginUIState = mutableStateOf(LoginUIState())
    var allErrorHandlingPassed = mutableStateOf(false)

    fun onEvent(event: LoginUIEvent) {


        ErrorHandlingRules()
        when (event) {
            is LoginUIEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
            }

            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }

            is LoginUIEvent.LoginButton -> {
                login()



            }


        }

    }

    private fun ErrorHandlingRules() {
        val emailResult = ErrorHandling.checkEmail(
            email = loginUIState.value.email
        )
        val passwordResult = ErrorHandling.checkPassword(
            password = loginUIState.value.password
        )

        loginUIState.value = loginUIState.value.copy(

            emailError = emailResult.status,
            passwordError = passwordResult.status
        )
        allErrorHandlingPassed.value = emailResult.status && passwordResult.status
    }

    private fun login() {
        val email = loginUIState.value.email
        val password = loginUIState.value.password
        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Screen.NavigationRouter.navigateTo(Screen.TranslatorScreen)

                }
            }
    }



}


