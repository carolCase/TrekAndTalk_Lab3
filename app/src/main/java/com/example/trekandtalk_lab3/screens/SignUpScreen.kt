package com.example.trekandtalk_lab3.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trekandtalk_lab3.ui.theme.DarkWhite
import components.HeadLine2Text
import components.SubHeadLineText

@Composable
fun SignUpScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .padding(45.dp)
            .background(color = DarkWhite)
    ){
      Column(modifier = Modifier
          .fillMaxSize(),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally)
      {
       SubHeadLineText(value = "Register new Account")
          HeadLine2Text(value = "Trek'n Talk")






      }





    }
}

@Preview
@Composable
fun SignUpPreview() {
    SignUpScreen()
}