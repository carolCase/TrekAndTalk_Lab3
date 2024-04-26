package com.example.trekandtalk_lab3.navigation

import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.trekandtalk_lab3.screens.LoginScreen
import com.example.trekandtalk_lab3.screens.SignUpScreen
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
            SignUpScreen()
        }

        is Screen.LoginScreen->{
            LoginScreen()
        }





    }

    
}
    }
}