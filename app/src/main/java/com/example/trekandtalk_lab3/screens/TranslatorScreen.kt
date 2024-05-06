package com.example.trekandtalk_lab3.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import com.example.trekandtalk_lab3.components.ClickableTextGoToProfile
import com.example.trekandtalk_lab3.components.DropDownMenuLanguage
import com.example.trekandtalk_lab3.components.TranslateButton
import com.example.trekandtalk_lab3.components.TranslateTextField
import com.example.trekandtalk_lab3.data.viewmodels.TranslateViewModel
import com.example.trekandtalk_lab3.ui.theme.DarkMediumBlue





@Composable
fun TranslatorScreen(
    translateViewModel: TranslateViewModel) {

    val state = translateViewModel.state.value
    val userNameState = remember { translateViewModel.fetchUserName() }


    LaunchedEffect(Unit) {
        userNameState.value = translateViewModel.fetchUserName().value
    }

            Column(
                modifier = Modifier
                    .background(DarkMediumBlue)
                    .fillMaxSize()
                    .padding(30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                /*  Icon(imageVector = Icons.Filled.AccountCircle,
        contentDescription = "",
        tint = DarkDarkBlue)*/

                Text(
                    text = "Welcome, ${userNameState.value}!",
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(text = "Choose Language")
                DropDownMenuLanguage()
                Spacer(modifier = Modifier.height(26.dp))
                TranslateTextField(translateViewModel)
                Spacer(modifier = Modifier.height(26.dp))


                TranslateButton(value = "Translate", onButtonClicked =
                { translateViewModel.onTranslateButtonClicked(state.textToBeTranslated)})

                Text(
                    text = state.translatedText,
                    color = Color.White,
                    modifier = Modifier
                        .align(
                            Alignment.CenterHorizontally
                        )
                        .padding(26.dp)
                )
                 ClickableTextGoToProfile(value = "Go to Profile")

            }


}




