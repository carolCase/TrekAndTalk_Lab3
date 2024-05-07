package com.example.trekandtalk_lab3.components



import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import androidx.compose.ui.unit.sp
import com.example.trekandtalk_lab3.ui.theme.DarkDarkGreen


@Composable
fun HeadLineText(value:String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            shadow = Shadow(color = DarkDarkGreen),
        ),
        color = Color.Black,
        textAlign = TextAlign.Center

    )
}

@Composable
fun HeadLine2Text(value:String) {
    Text(text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),  // heightIn wraps content
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            shadow = Shadow(color = Color.LightGray)
        ),
        color = DarkDarkGreen,
        textAlign = TextAlign.Center

    )
}

@Composable
fun SubHeadLineText(value: String) {
    Text(text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 25.dp),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleMedium
    )

}

@Composable
fun RegularText(value : String) {
    Text(text = value,
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleSmall)

}
/*
@Composable
 fun DisplayTranslatedTexts(translatedTexts: List<String>) {
    Column {
        translatedTexts.forEach { translatedText ->
            Text(text = translatedText, fontSize = 16.sp)
        }
    }
}*/
