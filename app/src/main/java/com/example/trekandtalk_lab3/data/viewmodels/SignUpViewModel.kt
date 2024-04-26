package com.example.trekandtalk_lab3.data.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.trekandtalk_lab3.data.uievents.SignUpUIEvent
import com.example.trekandtalk_lab3.data.uistates.SignUpUIState
import com.example.trekandtalk_lab3.rules.ErrorHandling

class SignUpViewModel:ViewModel() {
     var signUpUIState = mutableStateOf(SignUpUIState())
     var allErrorHandlingPassed = mutableStateOf(false)

    fun onEvent(event:SignUpUIEvent) {

        ErrorHandlingRules()
        when(event){
            is SignUpUIEvent.EmailChanged -> {
                signUpUIState.value = signUpUIState.value.copy(
                    email = event.email
                )
            }
            is SignUpUIEvent.UserNameChanged -> {
              signUpUIState.value = signUpUIState.value.copy(
                  userName = event.userName
              )
            }
             is SignUpUIEvent.PasswordChanged -> {
            signUpUIState.value = signUpUIState.value.copy(
                password = event.password
               )
            }
            is SignUpUIEvent.RegisterButton -> {
                signUpUIState.value = signUpUIState.value.copy()
            }


        }



    }

  private fun ErrorHandlingRules() {
        val userNameResult = ErrorHandling.checkUserName(
            userName = signUpUIState.value.userName
        )
        val emailResult = ErrorHandling.checkEmail(
            email = signUpUIState.value.email
        )
        val passwordResult = ErrorHandling.checkPassword(
            password = signUpUIState.value.password
        )

        signUpUIState.value = signUpUIState.value.copy(
            userNameError = userNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )
        allErrorHandlingPassed.value = emailResult.status && passwordResult.status
    }


}