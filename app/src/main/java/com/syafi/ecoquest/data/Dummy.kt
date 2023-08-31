package com.syafi.ecoquest.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import com.syafi.ecoquest.R
import androidx.compose.ui.res.painterResource
import com.syafi.ecoquest.model.Completed
import com.syafi.ecoquest.model.Komunitas

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

val komunitasList = listOf<Komunitas>(
    Komunitas(
        R.drawable.profile_picture,
        "Bambang",
        false,
        150,
        "Menyelasaikan daur ulang kemasan detergen",
        false
    ),
    Komunitas(
        R.drawable.profile_picture_2,
        "Windah",
        false,
        149,
        "Tips dari gue untuk mengurangi emisi karbon:\n1. Perbanyak jalan kaki/bersepeda kalau ke tempat yang dekat\n2. Matiin lampu atau listrik kalau belum butuh\n\nLess action tapi dampaknya bisa besar kalau semuanya action.\nSemangat guys!",
        false
    ),
    Komunitas(
        R.drawable.profile_picture_3,
        "Azizi",
        false,
        10,
        "Keren! Azizi naik ke level 2",
        true
    ),
    Komunitas(
        R.drawable.icon_logo,
        "Ecoquest",
        true,
        10,
        "Misi baru! Memperingati hari bumi, Ecoquest mengajak kalian untuk membersihkan pantai Kuta bersama Pandawara 5",
        false
    )
)