package com.syafi.ecoquest.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import com.syafi.ecoquest.R
import androidx.compose.ui.res.painterResource
import com.syafi.ecoquest.model.Completed

import com.syafi.ecoquest.model.Misi
import com.syafi.ecoquest.model.NavBar

val misiList = listOf<Misi>(
    Misi(
        "Tote bag 3 hari",
        10,
        0.5f,
        36
    ),
    Misi(
        "Daur ulang botol",
        30,
        1f,
        1
    ),
    Misi(
        "Bersepeda",
        30,
        0.4f,
        48
    )
)

val completedList= listOf<Completed>(
    Completed(
        "Daur Ulang Botol",
        30
    ),
    Completed(
        "Menanam pohon",
        100
    ),
    Completed(
        "Menyiram pohon",
        50
    ),
    Completed(
        "Berjalan ke sekolah",
        30
    ),
)
