package com.example.trekandtalk_lab3.screens


import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.trekandtalk_lab3.R
import com.example.trekandtalk_lab3.components.ButtonComponent


import com.example.trekandtalk_lab3.data.viewmodels.TranslateViewModel
import com.example.trekandtalk_lab3.navigation.Screen





@Composable
fun SavedTranslationScreen(translateViewModel: TranslateViewModel) {
    var translatedTexts by remember { mutableStateOf<List<String>>(emptyList()) }

    LaunchedEffect(Unit) {
        val fetchedData = translateViewModel.fetchTranslatedText()
        fetchedData.let {
            translatedTexts = it
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(35.dp)
                .verticalScroll(state = rememberScrollState())
        ) {

            Text(text = "Your translation log", style = MaterialTheme.typography.displaySmall)


                translatedTexts.let { texts ->
                    if (texts.isEmpty()) {
                        Text(text = "No translations available") // or any empty state message
                    } else {
                        texts.forEach { text ->
                            Text(text = text, style = MaterialTheme.typography.titleLarge, color = Color.Black)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

            ButtonComponent(value = "Logout", onButtonClicked = {
                translateViewModel.logout()
            })

            BackHandler {
                Screen.NavigationRouter.navigateTo(Screen.TranslatorScreen)
            }

        }
    }
}