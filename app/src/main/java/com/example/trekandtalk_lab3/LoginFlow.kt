package com.example.trekandtalk_lab3

import android.app.Application
import com.google.firebase.FirebaseApp

class LoginFlow : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}

/*
tasks like setting up third-party services, in this case Firebase.
 Extends Application.The Application class represents
 the base class for maintaining global application state.
 By extending this class, you can customize application behavior
 and perform initialization tasks.

Within LoginFlow, there's an onCreate() method override.
 This method is called when the application is first created.
 By overriding it, you can execute custom initialization logic.

 FirebaseApp.initializeApp(this) initializes Firebase services within
 the application context (this).
 This call typically sets up Firebase services such as Firebase Authentication,
 Firebase Realtime Database, Firebase Cloud Messaging, etc.

 LoginFlow class is responsible for initializing Firebase services
  when the application starts up*/