package com.example.gofilter.data

sealed class UIEvent {
    data class UsernameChanged(val username:String) : UIEvent()
    data class EmailChanged(val email:String) : UIEvent()
    data class PasswordChanged(val password: String) : UIEvent()
}
