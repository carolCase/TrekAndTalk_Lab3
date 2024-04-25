package com.example.trekandtalk_lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.trekandtalk_lab3.screens.WelcomeScreen
import com.example.trekandtalk_lab3.ui.theme.TrekandTalk_Lab3Theme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            TrekandTalk_Lab3Theme {
              Box (modifier = Modifier
                  .fillMaxSize(),
                  contentAlignment = Alignment.Center,)
              {
                WelcomeScreen()
              }

            }
        }
    }
}


