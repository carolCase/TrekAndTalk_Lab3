package com.example.trekandtalk_lab3.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.trekandtalk_lab3.data.Screen

sealed class NavigationRouter {
    object NavigationRouter {
        private var currentScreen: MutableState<Screen> = mutableStateOf(Screen.WelcomeScreen)
        fun navigateTo(destination: Screen){
            currentScreen.value = destination
        }
    }







}