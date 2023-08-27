package com.syafi.ecoquest.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.syafi.ecoquest.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

private val Rubik= FontFamily(
    Font(R.font.rubik_regular, FontWeight.Normal),
    Font(R.font.rubik_medium, FontWeight.Medium),
)

val RubikTypograpgy= Typography(
    h1 = TextStyle(
        fontFamily = Rubik,
        fontSize = 36.sp,
        fontWeight = FontWeight.Medium
    ),
    h2 = TextStyle(
        fontFamily = Rubik,
        fontSize = 32.sp,
        fontWeight = FontWeight.Medium
    ),
    h3 = TextStyle(
        fontFamily = Rubik,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium
    ),
    h4 = TextStyle(
        fontFamily = Rubik,
        fontSize = 22.sp,
        fontWeight = FontWeight.Medium
    ),
    h5 = TextStyle(
        fontFamily = Rubik,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium
    ),
    h6 = TextStyle(
        fontFamily = Rubik,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    body1 = TextStyle(
        fontFamily = Rubik,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    body2 = TextStyle(
        fontFamily = Rubik,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    ),
    subtitle1 = TextStyle(
        fontFamily = Rubik,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium
    ),
    subtitle2 = TextStyle(
        fontFamily = Rubik,
        fontSize = 11.sp,
        fontWeight = FontWeight.Medium
    ),
)