package com.syafi.ecoquest.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import com.syafi.ecoquest.R
import com.syafi.ecoquest.model.Misi
import com.syafi.ecoquest.model.NavBar

val misiList = listOf<Misi>(
    Misi(
        "Tote bag 3 hari",
        10,
        3
    ),
    Misi(
        "Daur ulang botol",
        30,
        3
    ),
    Misi(
        "Bersepeda ke IndoApril dalam sebulan",
        200,
        30
    ),
    Misi(
        "Membuat pupuk",
        50,
        2
    )
)

val navBarList = listOf<NavBar>(
    NavBar(
        "Beranda",
            R.drawable.icon_home
    )
)