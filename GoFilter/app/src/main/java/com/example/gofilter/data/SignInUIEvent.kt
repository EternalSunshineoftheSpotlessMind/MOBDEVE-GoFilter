package com.example.gofilter.data

sealed class SignInUIEvent {
    data class EmailChanged(val email:String) : SignInUIEvent()
    data class PasswordChanged(val password: String) : SignInUIEvent()

    object SignInButtonClicked : SignInUIEvent()
}