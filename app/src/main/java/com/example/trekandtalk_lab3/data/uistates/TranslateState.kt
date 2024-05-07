package com.example.trekandtalk_lab3.data.uistates



data class TranslateState(
    val textToBeTranslated: String = "",
    val translatedText: String = "",
    val translatedTexts: List<String> = emptyList()
    )


//val isButtonEnabled: Boolean = true