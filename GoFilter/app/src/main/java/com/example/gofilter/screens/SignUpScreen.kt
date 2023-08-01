package com.example.gofilter.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gofilter.components.BigTextComponent
import com.example.gofilter.components.ButtonComponent
import com.example.gofilter.components.MyPasswordField
import com.example.gofilter.components.MyTextField
import com.example.gofilter.components.SmallTextComponent

@Composable
fun SignUpScreen() {

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

            MyTextField(labelValue = "USERNAME")
            MyTextField(labelValue = "EMAIL")
            MyPasswordField(labelValue = "PASSWORD")

            Spacer(modifier = Modifier.padding(16.dp))

            ButtonComponent(value = "Create Account")

        }

    }
}

@Preview (showBackground = true)
@Composable
fun SignUpPreview() {
    SignUpScreen()
}