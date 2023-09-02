package com.syafi.ecoquest.presentation.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.syafi.ecoquest.R
import com.syafi.ecoquest.data.misiList
import com.syafi.ecoquest.data.rutinitasList
import com.syafi.ecoquest.model.Misi
import com.syafi.ecoquest.presentation.component.NavBar
import com.syafi.ecoquest.presentation.home.component.GreetUser
import com.syafi.ecoquest.presentation.home.component.MisiItem
import com.syafi.ecoquest.presentation.home.component.ProgressUser
import com.syafi.ecoquest.presentation.home.component.RutinitasItem
import com.syafi.ecoquest.ui.theme.green
import com.syafi.ecoquest.ui.theme.grey

@Composable
fun HomeScreen(navController: NavController, email: String) {

    var nama by remember {
        mutableStateOf("")
    }

    val scroll = rememberScrollState()

    val db = Firebase.firestore

    val context= LocalContext.current

    val docRef= db.collection(email).document("user_data")
    docRef.get()
        .addOnSuccessListener {  doc ->
            if (doc != null) {
                Log.d("tesemail", "${doc.data!!["fullName"]}")
                nama= doc.data!!["fullName"].toString()
            } else {
                Log.d("tesemail", "No such document")
            }
        }
        .addOnFailureListener {
            Toast.makeText(context, "gk dapt", Toast.LENGTH_SHORT).show()
        }

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(30.dp)
            .scrollable(scroll, Orientation.Vertical),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            GreetUser(nama)
            Spacer(modifier = Modifier.height(20.dp))
        }
        item {
            ProgressUser()
        }
        item {
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Misi",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Left
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
        items(misiList.size) {
            MisiItem(misi = misiList[it], index = it, navController = navController, email, 1)
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Rutinitas",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Left
            )

            Spacer(modifier = Modifier.height(10.dp))
        }

        items(rutinitasList.size) {
            RutinitasItem(navController = navController, rutinitas = rutinitasList[it], index = it)
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}