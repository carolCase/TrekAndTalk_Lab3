package com.example.trekandtalk_lab3.screens





import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trekandtalk_lab3.components.DropDownMenuLanguage

import com.example.trekandtalk_lab3.components.TranslateButton
import com.example.trekandtalk_lab3.components.TranslateTextField
import com.example.trekandtalk_lab3.data.viewmodels.LoginViewModel

import com.example.trekandtalk_lab3.data.viewmodels.TranslateViewModel

import com.example.trekandtalk_lab3.ui.theme.DarkMediumBlue
import com.example.trekandtalk_lab3.ui.theme.DarkWhite




@Composable
fun TranslatorScreen(
    loginViewModel: LoginViewModel,
    translateViewModel: TranslateViewModel) {

    val state = translateViewModel.state.value
    val userName = loginViewModel.displayUser()
    Surface(  color = DarkWhite,
      modifier = Modifier
          .fillMaxSize()
          .padding(35.dp)) {

  }
Column(modifier = Modifier
    .background(DarkMediumBlue)
    .fillMaxSize()
    .padding(30.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {

   Text(text = "Welcome, $userName!")
    Text(text = "Choose Language")
    DropDownMenuLanguage()
    Spacer(modifier = Modifier.height(26.dp))
    TranslateTextField(translateViewModel)
    Spacer(modifier = Modifier.height(26.dp))


    TranslateButton(value = "Translate", onButtonClicked =
    {translateViewModel.onTranslateButtonClicked(state.textToBeTranslated)})

    Text(
        text = state.translatedText,
        color = Color.White,
        modifier = Modifier.align(
            Alignment.CenterHorizontally
        ))



}

}




@Preview
@Composable
fun TranslatorPreview() {
    TranslatorScreen(loginViewModel = LoginViewModel(),
        translateViewModel = TranslateViewModel()
    )
}