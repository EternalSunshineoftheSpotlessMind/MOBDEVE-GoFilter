package com.example.gofilter.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.gofilter.data.rules.Validator
import com.example.gofilter.navigation.GoFilterRouter
import com.example.gofilter.navigation.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class SignUpViewModel : ViewModel() {
    private val TAG = SignUpViewModel::class.simpleName
    var signUpUIState = mutableStateOf(SignUpUIState())
    var allValidationsPassed = mutableStateOf(false)

    fun onEvent(event:SignUpUIEvent){
        validateDataWithRules()
        when(event){
            is SignUpUIEvent.UsernameChanged -> {
                signUpUIState.value = signUpUIState.value.copy(
                    username = event.username
                )
                printState()
            }
            is SignUpUIEvent.EmailChanged -> {
                signUpUIState.value = signUpUIState.value.copy(
                    email = event.email
                )
                printState()
            }
            is SignUpUIEvent.PasswordChanged -> {
                signUpUIState.value = signUpUIState.value.copy(
                    password = event.password
                )
                printState()
            }
            is SignUpUIEvent.SignUpButtonClicked -> {
                signUp()
            }
        }
    }

    private fun signUp () {
        Log.d(TAG, "Inside_signUp")
        printState()

        createUser(
            username = signUpUIState.value.username,
            email = signUpUIState.value.email,
            password = signUpUIState.value.password
        )
    }

    private fun validateDataWithRules() {
        val usernameResult = Validator.validateUsername(
            username = signUpUIState.value.username
        )
        val emailResult = Validator.validateEmail(
            email = signUpUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = signUpUIState.value.password
        )

        Log.d(TAG, "Inside_validateDataWithRules")
        Log.d(TAG, "username = $usernameResult")
        Log.d(TAG, "email = $emailResult")
        Log.d(TAG, "password = $passwordResult")

        signUpUIState.value = signUpUIState.value.copy(
            usernameError = usernameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

        //Enables button if all fields have valid data
        allValidationsPassed.value = usernameResult.status && emailResult.status && passwordResult.status
    }

    private fun printState() {
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, signUpUIState.value.toString())
    }

    //Create user in Firebase
    fun createUser(username: String, email: String, password: String) {
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                Log.d(TAG, "Inside_OnCompleteListener")
                Log.d(TAG, " isSuccessful = ${it.isSuccessful}")

                if(it.isSuccessful) {
                    GoFilterRouter.navigateTo(Screen.NavigationScreen)
                }
            }
            .addOnFailureListener {
                Log.d(TAG, "InsideOnFailureListener")
                Log.d(TAG, "Exception= ${it.message}")
                Log.d(TAG, "Exception= ${it.localizedMessage}")
            }
    }
}

