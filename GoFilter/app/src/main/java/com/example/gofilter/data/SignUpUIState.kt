package com.example.gofilter.data

data class SignUpUIState (
    var username :String = "",
    var email :String = "",
    var password :String ="",

    var usernameError :Boolean = false,
    var emailError :Boolean = false,
    var passwordError :Boolean = false
)