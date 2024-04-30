package com.example.trekandtalk_lab3.navigation


import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.trekandtalk_lab3.data.viewmodels.LoginViewModel

import com.example.trekandtalk_lab3.data.viewmodels.SignUpViewModel
import com.example.trekandtalk_lab3.data.viewmodels.TranslateViewModel
import com.example.trekandtalk_lab3.screens.LoginScreen
import com.example.trekandtalk_lab3.screens.SignUpScreen
import com.example.trekandtalk_lab3.screens.TranslatorScreen
import com.example.trekandtalk_lab3.screens.WelcomeScreen

@Composable
fun ScreenNavigator() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
Crossfade(targetState = Screen.NavigationRouter.currentScreen, label = "")
{
        currentState->
    when(currentState.value){

        is Screen.WelcomeScreen->{
            WelcomeScreen()
        }

        is Screen.SignUpScreen->{
            SignUpScreen(signUpViewModel = SignUpViewModel())
        }

        is Screen.LoginScreen->{
            LoginScreen(loginViewModel = LoginViewModel())
        }
         is Screen.TranslatorScreen->{
             TranslatorScreen(
                 loginViewModel = LoginViewModel(),
                 translateViewModel = TranslateViewModel())
         }




    }

    
}
    }
}