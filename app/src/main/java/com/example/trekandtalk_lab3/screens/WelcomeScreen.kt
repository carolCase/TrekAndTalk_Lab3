package com.example.trekandtalk_lab3.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource

import com.example.trekandtalk_lab3.R
import com.example.trekandtalk_lab3.components.HeadLineText
import com.example.trekandtalk_lab3.components.WelcomeButton

@Composable
fun WelcomeScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
      color = MaterialTheme.colorScheme.background,

    ) {



        Box(modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(id = R.drawable.hikers ),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize())
            HeadLineText(value = "Trek'n Talk")
            WelcomeButton()
        }


    }
}