package com.example.gofilter.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gofilter.R
import com.example.gofilter.navigation.GoFilterRouter
import com.example.gofilter.navigation.Screen

val krubFamily = FontFamily(
    Font(R.font.krub_regular, FontWeight.Normal),
    Font(R.font.krub_bold, FontWeight.Bold)
)

val koulenFamily = FontFamily(
    Font(R.font.koulen_regular, FontWeight.Normal)
)
@Composable
fun BigTextComponent(value: String, size: Int, height: Int) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp),
        style = TextStyle(
            fontSize = size.sp,
            fontFamily = koulenFamily,
            color = colorResource(id = R.color.gray)
        ),
        textAlign = TextAlign.Center
    )
}

@Composable
fun SmallTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 15.sp,
            fontFamily = krubFamily,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.gray)
        ),
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue: String, onTextSelected: (String) -> Unit) {
    val textValue = remember { mutableStateOf("") }

    OutlinedTextField(
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.gray),
            focusedLabelColor = colorResource(id = R.color.gray),
            cursorColor = colorResource(id = R.color.gray),
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onTextSelected(it)
        },
        singleLine = true,
        maxLines = 1
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPasswordField(labelValue: String, onTextSelected: (String) -> Unit) {
    val password = remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current
    val passwordVisible = remember { mutableStateOf(false) }

    OutlinedTextField(
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.gray),
            focusedLabelColor = colorResource(id = R.color.gray),
            cursorColor = colorResource(id = R.color.gray),
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        value = password.value,
        onValueChange = {
            password.value = it
            onTextSelected(it)
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            var description = if (passwordVisible.value) {
                "Hide password"
            } else {
                "Show password"
            }

            IconButton(onClick = {passwordVisible.value = !passwordVisible.value}) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun ButtonComponent(value: String, onButtonClicked : () -> Unit, isEnabled : Boolean = false) {
    Button(
        onClick = {
                  onButtonClicked.invoke()
                  },
        modifier = Modifier
            .width(250.dp)
            .heightIn(48.dp)
            .padding(8.dp),
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(50.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple)),
        enabled = isEnabled
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 23.sp,
                fontFamily = koulenFamily
            )
        }
    }
}