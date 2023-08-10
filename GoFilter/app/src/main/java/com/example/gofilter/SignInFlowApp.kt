package com.example.gofilter

import android.app.Application
import com.google.firebase.FirebaseApp

class SignInFlowApp : Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}