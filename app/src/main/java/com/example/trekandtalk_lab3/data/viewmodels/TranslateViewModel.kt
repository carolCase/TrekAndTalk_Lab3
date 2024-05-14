package com.example.trekandtalk_lab3.data.viewmodels
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.trekandtalk_lab3.data.uistates.TranslateState
import androidx.compose.runtime.State
import com.example.trekandtalk_lab3.navigation.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class TranslateViewModel : ViewModel() {

    private val usersRef = FirebaseDatabase.getInstance("https://trek-and-talk-default-rtdb.europe-west1.firebasedatabase.app").getReference("users")
    private val currentUser = FirebaseAuth.getInstance().currentUser

    private val _state = mutableStateOf(TranslateState())
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

                val currentState = state.value
                _state.value = currentState.copy(
                    translatedText = translatedText
                )
                updateTranslatedTextInDatabase(translatedText)
                addTranslatedText(translatedText)
                Log.d(TAG, "Translation successful")
            }
            .addOnFailureListener { e ->
                Log.e(TAG, "Translation failed", e)
            }
    }

    private fun updateTranslatedTextInDatabase(translatedText: String) {
        val uid = FirebaseAuth.getInstance().currentUser?.uid
        if (uid != null) {
            usersRef.child(uid).child("translatedText").setValue(translatedText)
                .addOnSuccessListener {
                    Log.d(TAG, "Translated text added to realtime database")
                }
                .addOnFailureListener { e ->
                    Log.e(TAG, "Failed to add translated text to realtime database", e)
                }
        }
    }

    fun fetchUserName(): MutableState<String> {
        val userNameState = mutableStateOf("")
        if (currentUser != null) {
            val userId = currentUser.uid
            usersRef.child(userId).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val userName = snapshot.child("userName").getValue(String::class.java) ?: ""
                    userNameState.value = userName
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d(TAG, "Failed to get user")
                }
            })
        }
        return userNameState
    }



    private fun addTranslatedText(translatedText: String) {
        currentUser?.uid?.let { uid ->
            val newRef = usersRef.child(uid).child("translatedText")
            newRef.setValue(translatedText)
                .addOnSuccessListener {
                    Log.d(TAG, "Translated text added to realtime database")
                }
                .addOnFailureListener { e ->
                    Log.e(TAG, "Failed to add translated text to realtime database", e)
                }
        }
    }



    fun deleteTranslatedTextFromDatabase() {
        val uid = FirebaseAuth.getInstance().currentUser?.uid
        if (uid != null) {
            usersRef.child(uid).child("translatedText").removeValue()
                .addOnSuccessListener {
                    Log.d(TAG, "Translated text deleted from realtime database")
                }
                .addOnFailureListener { e ->
                    Log.e(TAG, "Failed to delete translated text from realtime database", e)
                }
        }
    }


    suspend fun fetchTranslatedText(): List<String> = withContext(Dispatchers.IO) {
        currentUser?.uid?.let { uid ->
            Log.d(TAG,"debugging array")
            val translatedTextRef = usersRef.child(uid)
            val fetchedTranslatedTexts = mutableListOf<String>()
            Log.d(TAG,"debugging array")

            try {//here is where i need to specify key TODO
                val dataSnapshot = translatedTextRef.get().await()
                for (childSnapshot in dataSnapshot.children) {
                    val translatedText = childSnapshot.getValue(String::class.java)

                    // DEBUGGING
                    println(childSnapshot.key)

                    if (childSnapshot.key == "userName") {
                        println("USERNAME EXISTS")
                    }

                    translatedText?.let {
                        fetchedTranslatedTexts.add(it)
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching translated texts: $e")
            }

            fetchedTranslatedTexts
        } ?: emptyList()
    }



    fun logout() {
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut() //log Out
        val authStateListener = FirebaseAuth.AuthStateListener {
            if (it.currentUser == null) {
                Screen.NavigationRouter.navigateTo(Screen.LoginScreen)
            }
        }
        firebaseAuth.addAuthStateListener(authStateListener)
    }
}
