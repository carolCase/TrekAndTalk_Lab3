package com.example.trekandtalk_lab3.data.viewmodels

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.trekandtalk_lab3.data.uistates.TranslateState
import androidx.compose.runtime.State
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions

class TranslateViewModel: ViewModel() {

    private val _state = mutableStateOf((TranslateState())
    )

   val state: State<TranslateState> = _state

    fun onTextTranslatedChange(text: String) {
        _state.value = state.value.copy(
            textToBeTranslated = text
        )
    }

     fun onTranslateButtonClicked(text:String,context:Context)
     {
         val options  = TranslatorOptions
             .Builder()
             .setSourceLanguage(TranslateLanguage.ENGLISH)
             .setTargetLanguage(TranslateLanguage.SPANISH)
             .build()

         val languageTranslator = Translation
             .getClient(options)
         languageTranslator.translate(text)
             .addOnSuccessListener {
                  // Log.d(TAG, "working fine");
                 translatedText ->
                 _state.value = state.value.copy(
                     translatedText = translatedText
                 )
             }
     }




}