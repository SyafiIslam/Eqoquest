package com.syafi.ecoquest.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    text: String,
    placeholder: String,
    trailingIcon: ImageVector? = null,
    showPassword: Boolean = false,
    onValueChange: (String) -> Unit = {},
    onPasswordToggle: (Boolean) -> Unit = {},
    label: String? = null,
    isPassword: Boolean = false,
    maxLine: Int= 1,
    minLine: Int= 1
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = {
            onValueChange(it)
        },
        placeholder = {
            Text(text = placeholder)
        },
        trailingIcon = {
            if (trailingIcon != null) {
                if (showPassword) {
                    IconButton(onClick = { onPasswordToggle(!showPassword) }) {
                        Icon(
                            imageVector = trailingIcon,
                            contentDescription = "show",
                            Modifier.size(25.dp)
                        )
                    }
                } else {
                    IconButton(onClick = { onPasswordToggle(!showPassword) }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "hide",
                            Modifier.size(25.dp)
                        )
                    }
                }
            }
        },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            textColor = Color.Black
        ),
        label = {
            label?.let {
                Text(text = it)
            }
        },
        visualTransformation =
        if (isPassword) {
            if (showPassword) VisualTransformation.None
            else PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        keyboardOptions =
        if (isPassword) KeyboardOptions(keyboardType = KeyboardType.Password)
        else KeyboardOptions(keyboardType = KeyboardType.Text),
        maxLines = maxLine,
        minLines = minLine
    )
}