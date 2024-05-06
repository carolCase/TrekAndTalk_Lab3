package com.example.trekandtalk_lab3.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trekandtalk_lab3.data.viewmodels.TranslateViewModel

import com.example.trekandtalk_lab3.navigation.Screen

import com.example.trekandtalk_lab3.ui.theme.MediumBeige


@Composable
fun SavedTranslationScreen(translateViewModel: TranslateViewModel) {

    val state = translateViewModel.state.value

    LaunchedEffect(Unit) {
            translateViewModel.fetchTranslatedText()
        }

    Column(
        modifier = Modifier
            .background(color = MediumBeige)
            .fillMaxSize()
            .padding(35.dp)
    ){
        Text(text = "Your translation log", style = MaterialTheme.typography.titleMedium)

        state.forEach{ translatedText ->
            Text(text = translatedText, fontSize = 16.sp, modifier = Modifier.padding(vertical = 8.dp))
        }


        BackHandler {
  Screen.NavigationRouter.navigateTo(Screen.TranslatorScreen)
}

    }
}