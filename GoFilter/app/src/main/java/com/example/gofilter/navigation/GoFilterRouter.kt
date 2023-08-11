package com.example.gofilter.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

//Options of screens that you can navigate to
sealed class Screen() {
    object SignInScreen : Screen()
    object SignUpScreen : Screen()
    object NavigationScreen : Screen()
}

object GoFilterRouter {
    val currentScreen : MutableState<Screen> = mutableStateOf(Screen.SignInScreen)

    //Use this function to navigate to other screens
    fun navigateTo(destination : Screen) {
        currentScreen.value = destination
    }
}