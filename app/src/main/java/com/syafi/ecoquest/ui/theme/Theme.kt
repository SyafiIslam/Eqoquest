package com.syafi.ecoquest.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

//private val DarkColorPalette = darkColors(
//    primary = Green,
//    primaryVariant = Purple700,
//    secondary = Sage
//)

private val LightColorPalette = lightColors(
    primary = Green,
    primaryVariant = Purple700,
    secondary = Sage

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun EcoQuestTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        LightColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = RubikTypograpgy,
        shapes = Shapes,
        content = content
    )
}