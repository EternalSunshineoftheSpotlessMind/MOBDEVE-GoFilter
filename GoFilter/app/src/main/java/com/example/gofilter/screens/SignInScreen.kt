package com.example.gofilter.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.gofilter.components.koulenFamily
import com.example.gofilter.components.krubFamily
import com.example.gofilter.data.SignInUIEvent
import com.example.gofilter.data.SignInViewModel
import com.example.gofilter.data.SignUpUIEvent
import com.example.gofilter.navigation.GoFilterRouter
import com.example.gofilter.navigation.Screen
import com.example.gofilter.navigation.SystemBackButtonHandler

@Composable
fun SignInScreen(signInViewModel: SignInViewModel = viewModel()) {
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
            BigTextComponent(value = "Sign In", size = 62, height = 82)
            SmallTextComponent(value = "Welcome Back")

            Spacer(modifier = Modifier.padding(16.dp))

            MyTextField(
                labelValue = "EMAIL",
                onTextSelected = { signInViewModel.onEvent(SignInUIEvent.EmailChanged(it)) },
                errorStatus = signInViewModel.signInUIState.value.emailError
            )
            MyPasswordField(
                labelValue = "PASSWORD",
                onTextSelected = { signInViewModel.onEvent(SignInUIEvent.PasswordChanged(it)) },
                errorStatus = signInViewModel.signInUIState.value.passwordError
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "Don't have an account?",
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
                    text = AnnotatedString("SIGN UP"),
                    onClick = { GoFilterRouter.navigateTo(Screen.SignUpScreen) },
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
                value = "Sign In",
                onButtonClicked = {
                    signInViewModel.onEvent(SignInUIEvent.SignInButtonClicked)
                },
                isEnabled = signInViewModel.allValidationsPassed.value
            )
        }
        SystemBackButtonHandler {
            GoFilterRouter.navigateTo(Screen.SignUpScreen)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    SignInScreen()
}