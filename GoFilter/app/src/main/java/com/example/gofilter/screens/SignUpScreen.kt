package com.example.gofilter.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gofilter.R
import com.example.gofilter.components.BigTextComponent
import com.example.gofilter.components.ButtonComponent
import com.example.gofilter.components.MyPasswordField
import com.example.gofilter.components.MyTextField
import com.example.gofilter.components.SmallTextComponent
import com.example.gofilter.components.krubFamily
import com.example.gofilter.data.SignInViewModel
import com.example.gofilter.data.UIEvent
import com.example.gofilter.navigation.GoFilterRouter
import com.example.gofilter.navigation.Screen
import com.example.gofilter.navigation.SystemBackButtonHandler

//Sign Up Screen
@Composable
fun SignUpScreen(signInViewModel: SignInViewModel = viewModel()) {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BigTextComponent(value = "CREATE AN ACCOUNT", size = 43, height = 60)
            SmallTextComponent(value = "Enter your credentials")

            Spacer(modifier = Modifier.padding(16.dp))

            MyTextField(
                labelValue = "USERNAME",
                onTextSelected = { signInViewModel.onEvent(UIEvent.UsernameChanged(it)) },
                errorStatus = signInViewModel.signUpUIState.value.usernameError
            )
            MyTextField(
                labelValue = "EMAIL",
                onTextSelected = { signInViewModel.onEvent(UIEvent.EmailChanged(it)) },
                errorStatus = signInViewModel.signUpUIState.value.emailError
            )
            MyPasswordField(
                labelValue = "PASSWORD",
                onTextSelected = { signInViewModel.onEvent(UIEvent.PasswordChanged(it)) },
                errorStatus = signInViewModel.signUpUIState.value.passwordError
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "Already have an account?",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = krubFamily,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.gray)
                    ),
                    textAlign = TextAlign.Center
                )
                ClickableText(
                    modifier = Modifier
                        .padding(5.dp),
                    text = AnnotatedString("SIGN IN"),
                    onClick = { GoFilterRouter.navigateTo(Screen.SignInScreen) },
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = krubFamily,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.purple)
                    )
                )
            }

            Spacer(modifier = Modifier.padding(16.dp))

            ButtonComponent(
                value = "Create Account",
                onButtonClicked = {
                    signInViewModel.onEvent(UIEvent.SignUpButtonClicked)
                },
                isEnabled = signInViewModel.allValidationsPassed.value
            )
        }
    }
    SystemBackButtonHandler {
        GoFilterRouter.navigateTo(Screen.SignInScreen)
    }
}

//Preview for Sign Up Screen
@Preview (showBackground = true)
@Composable
fun SignUpPreview() {
    SignUpScreen()
}