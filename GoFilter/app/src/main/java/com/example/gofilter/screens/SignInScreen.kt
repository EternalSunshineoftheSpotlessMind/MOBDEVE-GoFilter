package com.example.gofilter.screens

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.gofilter.R
import com.example.gofilter.components.BigTextComponent
import com.example.gofilter.components.ButtonComponent
import com.example.gofilter.components.MyPasswordField
import com.example.gofilter.components.MyTextField
import com.example.gofilter.components.SmallTextComponent
import com.example.gofilter.components.krubFamily

@Composable
fun SignInScreen() {
    val navController = rememberNavController()

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

            MyTextField(labelValue = "EMAIL")
            MyPasswordField(labelValue = "PASSWORD")

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
                Text(
                    modifier = Modifier
                        .padding(5.dp)
                        .clickable { navController.navigate("signup") },
                    text = "SIGN UP",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = krubFamily,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.purple)
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.padding(16.dp))

            ButtonComponent(value = "Sign In")

        }

    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    SignInScreen()
}