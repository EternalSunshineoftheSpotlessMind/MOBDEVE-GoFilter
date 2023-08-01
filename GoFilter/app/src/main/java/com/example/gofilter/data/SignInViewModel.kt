package com.example.gofilter.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {
    var signUpUIState = mutableStateOf(SignUpUIState())

    fun onEvent(event:UIEvent){
        when(event){
            is UIEvent.UsernameChanged -> {
                signUpUIState.value = signUpUIState.value.copy(
                    username = event.username
                )
            }
            is UIEvent.EmailChanged -> {
                signUpUIState.value = signUpUIState.value.copy(
                    email = event.email
                )
            }
            is UIEvent.PasswordChanged -> {
                signUpUIState.value = signUpUIState.value.copy(
                    password = event.password
                )
            }
        }
    }
}