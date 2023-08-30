package com.syafi.ecoquest.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syafi.ecoquest.ui.theme.dark

@Composable
fun CustomButton(
    text: String,
    icon: Int? = null,
    color: Color = MaterialTheme.colors.dark,
    textColor: Color= Color.White
) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(Modifier.padding(vertical = 6.dp)) {
            icon?.let {
                AsyncImage(model = icon, contentDescription = text, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(10.dp))
            }
            Text(text = text, style = MaterialTheme.typography.subtitle1, color = textColor)
        }
    }
}