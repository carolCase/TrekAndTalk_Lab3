package com.example.trekandtalk_lab3.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
    data object WelcomeScreen : Screen()
    data object SignUpScreen : Screen()
    data object LoginScreen : Screen()
    data object TranslatorScreen :Screen()
    data object SavedTranslationScreen : Screen()




    object NavigationRouter {
         var currentScreen: MutableState<Screen> = mutableStateOf(WelcomeScreen)
        fun navigateTo(destination: Screen){
            currentScreen.value = destination
        }
    }

}