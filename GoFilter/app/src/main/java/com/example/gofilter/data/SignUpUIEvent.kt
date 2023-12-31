package com.example.gofilter.data

sealed class SignUpUIEvent {
    data class UsernameChanged(val username:String) : SignUpUIEvent()
    data class EmailChanged(val email:String) : SignUpUIEvent()
    data class PasswordChanged(val password: String) : SignUpUIEvent()

    object SignUpButtonClicked : SignUpUIEvent()
}
