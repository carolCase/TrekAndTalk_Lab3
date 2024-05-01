package com.example.trekandtalk_lab3.data.viewmodels

import android.content.ContentValues.TAG

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.trekandtalk_lab3.data.uistates.TranslateState
import androidx.compose.runtime.State
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions

class TranslateViewModel: ViewModel() {

    private val _state = mutableStateOf((TranslateState()))

    val state: State<TranslateState> = _state

    fun onTextTranslatedChange(text: String) {
        _state.value = state.value.copy(
            textToBeTranslated = text
        )
    }

    fun onTranslateButtonClicked(text: String) {
        val options = TranslatorOptions
            .Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.SPANISH)
            .build()

        val languageTranslator = Translation
            .getClient(options)


        languageTranslator.downloadModelIfNeeded()
            .continueWithTask { task ->
                if (task.isSuccessful) {
                    languageTranslator.translate(text)
                } else {
                    Log.e(TAG, "Model download failed", task.exception)
                    throw task.exception ?: RuntimeException("Model download failed")
                }
            }
            .addOnSuccessListener { translatedText ->
                // Translation successful, update the state
                val currentState = state.value
                _state.value = currentState.copy(
                    translatedText = translatedText
                )
                Log.d(TAG, "Translation successful")
                Log.d(TAG, "Translated Text: $translatedText")
            }
            .addOnFailureListener { e ->
                // Translation failed, log error
                Log.e(TAG, "Translation failed", e)
            }
    }

}







