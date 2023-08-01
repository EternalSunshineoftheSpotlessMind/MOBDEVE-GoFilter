package com.example.gofilter.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen() {
    object SignInScreen : Screen()
    object SignUpScreen : Screen()
}

object GoFilterRouter {
    val currentScreen : MutableState<Screen> = mutableStateOf(Screen.SignInScreen)

    fun navigateTo(destination : Screen) {
        currentScreen.value = destination
    }
}