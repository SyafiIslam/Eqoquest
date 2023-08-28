package com.syafi.ecoquest.presentation.welcome

import androidx.annotation.DrawableRes
import com.syafi.ecoquest.R

sealed class WelcomePages(
    @DrawableRes
    val image: Int,
    val title: String,
    val btnText: String
) {
    object first : WelcomePages(
        image = R.drawable.welcome1,
        title = "Bentuk kebiasaan baik bersama ",
        btnText = "Selanjutnya"
    )

    object second : WelcomePages(
        image = R.drawable.welcome2,
        title = "Temukan fitur menyenangkan",
        btnText = "Selanjutnya"
    )

    object third : WelcomePages(
        image = R.drawable.welcome3,
        title = "Mainkan dan berkontribusi",
        btnText = "Mulai Pertualangan!"

    )
}