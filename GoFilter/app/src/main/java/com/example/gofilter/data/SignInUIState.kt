package com.example.gofilter.data

data class SignInUIState (
    var email :String = "",
    var password :String ="",

    var emailError :Boolean = false,
    var passwordError :Boolean = false
)