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
import com.syafi.ecoquest.model.Misi
import com.syafi.ecoquest.presentation.component.NavBar
import com.syafi.ecoquest.presentation.home.component.MisiItem
import com.syafi.ecoquest.ui.theme.green
import com.syafi.ecoquest.ui.theme.grey

@Composable
fun HomeScreen(navController: NavController, email: String) {

    var nama by remember {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .scrollable(scrollState, Orientation.Vertical),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Selamat datang,",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = nama,
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.green,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Box(
                modifier = Modifier
                    .size(65.dp)
                    .clip(CircleShape)
            ) {
                AsyncImage(
                    model = R.drawable.profile_picture,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = 7.dp
        ) {
            Row(
                Modifier.padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(80.dp)
                                .width(20.dp),
                            color = MaterialTheme.colors.green,
                            progress = 0.5f,
                            strokeWidth = 5.dp,
                        )
                        Text(
                            text = "2",
                            style = MaterialTheme.typography.h6,
                            color = MaterialTheme.colors.green,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "150 exp",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.green,
                    )
                }

                Spacer(modifier = Modifier.width(30.dp))

                Column {
                    Text(
                        text = "Hebat!",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Kamu menyelesaikan",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "5 misi",
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.green,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

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

        LazyColumn {
            items(misiList.size) {
                MisiItem(misi = misiList[it], it, navController, email, id = 1)
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Misi",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Left
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Misi",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Left
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Misi",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Left
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Misi",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Left
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Misi",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Left
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Misi",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Left
        )


    }
}

@Composable
fun Home() {

    val scroll = rememberScrollState()

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(30.dp)
            .scrollable(scroll, Orientation.Vertical)
    ) {
        item {

        }
    }
}