package com.syafi.ecoquest.presentation.register

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.syafi.ecoquest.model.UserData
import com.syafi.ecoquest.util.Routes

class RegisterViewModel: ViewModel() {

    val auth = FirebaseAuth.getInstance()
    val db = Firebase.firestore

    var fullName by mutableStateOf("")


    var email by mutableStateOf("")


    var password by mutableStateOf("")

    fun handleRegister(navController: NavController, context: Context) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                val user = it.user
                val userData = UserData(
                    fullName,
                    email,
                    password
                )

                if (user != null) {
                    db.collection(email)
                        .document("user_data")
                        .set(userData)
                        .addOnSuccessListener {
                            Toast.makeText(
                                context,
                                "Akun berhasil dibuat",
                                Toast.LENGTH_SHORT
                            ).show()
                            navController.navigate(Routes.LOGIN)
                        }
                        .addOnFailureListener {
                            Toast.makeText(
                                context,
                                "${it.message}",
                                Toast.LENGTH_LONG
                            ).show()
                            navController.navigate(Routes.LOGIN)
                        }
                }
            }
            .addOnFailureListener {
                Toast.makeText(
                    context,
                    "${it.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    fun handleBlank(context: Context) {
        Toast.makeText(context, "Isi semua data", Toast.LENGTH_SHORT).show()
    }
}