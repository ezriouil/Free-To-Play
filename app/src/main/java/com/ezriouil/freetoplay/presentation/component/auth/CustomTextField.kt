package com.ezriouil.freetoplay.presentation.component.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ezriouil.freetoplay.presentation.theme.Kaiseiopti
import com.ezriouil.freetoplay.presentation.theme.RedErrorLight
import com.ezriouil.freetoplay.utils.TextFieldType
import com.ezriouil.freetoplay.validation.state.ValidationState

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    state: ValidationState,
    onValueChange: (String) -> Unit,
    label: String,
    backgroundColor: Color = Color.White,
    textFieldColors: Color = Color.Black,
    hintStyle: TextStyle = MaterialTheme.typography.subtitle2,
    type: TextFieldType,
    maxLiens: Int = 1,
    singleLine: Boolean = true,
) {
    var passwordInvisible by remember { mutableStateOf(true) }
    Column {
        OutlinedTextField(
            value = state.text,
            maxLines = maxLiens,
            singleLine = singleLine,
            textStyle = TextStyle(
                fontFamily = Kaiseiopti,
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                color = textFieldColors
            ),
            label = { Text(text = label, style = hintStyle, color = textFieldColors) },
            onValueChange = onValueChange,
            modifier = modifier
                .fillMaxWidth()
                .requiredHeight(66.dp)
                .padding(horizontal = 8.dp)
                .shadow(elevation = 0.dp),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = textFieldColors,
                unfocusedIndicatorColor = textFieldColors,
                focusedLabelColor = textFieldColors,
                disabledIndicatorColor = textFieldColors,
                focusedIndicatorColor = textFieldColors,
                backgroundColor = backgroundColor
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = when (type) {
                    TextFieldType.PASSWORD -> KeyboardType.Password
                    TextFieldType.TEXT -> KeyboardType.Text
                    TextFieldType.EMAIL -> KeyboardType.Email
                }
            ),
            leadingIcon = {
                when (type) {
                    TextFieldType.PASSWORD -> {
                        Icon(
                            imageVector = Icons.Default.Password,
                            contentDescription = null,
                            tint = textFieldColors
                        )
                    }
                    TextFieldType.TEXT -> {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = textFieldColors
                        )
                    }
                    TextFieldType.EMAIL -> {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null,
                            tint = textFieldColors
                        )

                    }
                }
            },
            visualTransformation =
            when (type) {
                TextFieldType.PASSWORD -> {
                    if (!passwordInvisible) VisualTransformation.None
                    else PasswordVisualTransformation()
                }
                else -> VisualTransformation.None
            },
            trailingIcon = {
                when (type) {
                    TextFieldType.PASSWORD -> {
                        Icon(
                            modifier = modifier.clickable {
                                passwordInvisible = !passwordInvisible
                            },
                            imageVector = if (passwordInvisible) Icons.Default.CodeOff else Icons.Default.Code,
                            contentDescription = null,
                            tint = textFieldColors
                        )
                    }
                    else -> Unit
                }
            }
        )
        if (state.hasError && state.errorMsg != null) {
            Text(
                modifier = modifier
                    .align(alignment = Alignment.End)
                    .padding(top = 8.dp, end = 4.dp),
                text = state.errorMsg,
                color = RedErrorLight,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}