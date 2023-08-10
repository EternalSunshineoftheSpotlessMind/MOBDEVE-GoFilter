package com.example.gofilter.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.gofilter.data.rules.Validator
import com.example.gofilter.navigation.GoFilterRouter
import com.example.gofilter.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

class SignInViewModel : ViewModel() {
    private val TAG = SignInViewModel::class.simpleName
    var signInUIState = mutableStateOf(SignInUIState())
    var allValidationsPassed = mutableStateOf(false)

    fun onEvent(event: SignInUIEvent) {
        when(event){
            is SignInUIEvent.EmailChanged -> {
                signInUIState.value = signInUIState.value.copy(
                    email = event.email
                )
            }
            is SignInUIEvent.PasswordChanged -> {
                signInUIState.value = signInUIState.value.copy(
                    password = event.password
                )
            }
            is SignInUIEvent.SignInButtonClicked -> {
                signin()
            }
        }

        validateSignInUIDataWithRules()
    }

    private fun validateSignInUIDataWithRules() {
        val emailResult = Validator.validateEmail(
            email = signInUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = signInUIState.value.password
        )

        signInUIState.value = signInUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationsPassed.value = emailResult.status && passwordResult.status
    }

    //Sign in existing user in Firebase
    private fun signin() {
        val email = signInUIState.value.email
        val password = signInUIState.value.password

        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG, "Inside_signin_success")
                Log.d(TAG, "${it.isSuccessful}")

                if(it.isSuccessful){
                    GoFilterRouter.navigateTo(Screen.NavigationScreen)
                }
            }
            .addOnFailureListener {
                Log.d(TAG, "Inside_signin_failure")
                Log.d(TAG, "${it.localizedMessage}")
            }
    }
}