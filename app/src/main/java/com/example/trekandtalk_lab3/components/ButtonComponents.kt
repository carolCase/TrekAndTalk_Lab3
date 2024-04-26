package com.example.trekandtalk_lab3.components

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trekandtalk_lab3.ui.theme.DarkDarkGreen
import com.example.trekandtalk_lab3.ui.theme.DarkWhite
import kotlinx.coroutines.delay



@Composable
fun WelcomeButton() {
    var buttonVisible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        delay(3000)
        buttonVisible = true
    }

    if (buttonVisible) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color.Black, Color.Transparent)
                        ),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Text(
                        text = "Press to Enter",
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp

                    )
                }
            }
        }
    }
}


@Composable
fun StandardButton(value:String, onButtonClicked : ()-> Unit, isEnabled : Boolean = false) {
    Button(onClick = { onButtonClicked.invoke()}, modifier = Modifier
        .fillMaxWidth()
        .heightIn(48.dp),
        enabled = isEnabled,
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    )
    {
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(colors = listOf(DarkDarkGreen, Color.LightGray)),
                shape = RoundedCornerShape(50.dp),

                ),
            contentAlignment = Alignment.Center
        )
        {
            Text(text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold)
        }
    }
}
