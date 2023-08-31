package com.syafi.ecoquest.presentation.profil

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syafi.ecoquest.ui.theme.green
import com.syafi.ecoquest.R
import com.syafi.ecoquest.data.completedList
import com.syafi.ecoquest.presentation.component.CustomLinearProgressBar
import com.syafi.ecoquest.presentation.profil.component.CompletedItem
import com.syafi.ecoquest.presentation.profil.component.Experience
import com.syafi.ecoquest.ui.theme.cream
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.ui.theme.sage


@Composable
fun ProfileScreen() {
    Box {
        Column(
            Modifier
                .fillMaxSize()
                .padding(vertical = 30.dp, horizontal = 15.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                elevation = 10.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 10.dp),
                backgroundColor = MaterialTheme.colors.cream,
                shape = RoundedCornerShape(15.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(65.dp))
                    Text(text = "Bambang", style = MaterialTheme.typography.h5)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "bambangganteng.gmail.com",
                        color = MaterialTheme.colors.sage,
                        style = MaterialTheme.typography.subtitle1
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Edit",
                        textDecoration = TextDecoration.Underline,
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier.clickable {

                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Experience()
                    Spacer(modifier = Modifier.height(10.dp))
                    completedList.forEach { 
                        CompletedItem(completedData = it)
                    }
                }
            }
        }
        ProfilePicture(
            level = 3,
            image = R.drawable.profile_picture,
            modifier = Modifier
                .align(Alignment.TopCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    ProfileScreen()
}

//Box(contentAlignment = Alignment.TopCenter) {
//    Card(
//        elevation = 10.dp,
//        modifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp),
//        backgroundColor = MaterialTheme.colors.cream
//    ) {
//        Column(
//            Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Box() {
//                AsyncImage(
//                    model = R.drawable.profile_picture,
//                    contentDescription = "profil_pic",
//                    Modifier
//                        .size(96.dp)
//                        .offset(y = (-25).dp)
//                        .clip(CircleShape)
//                        .align(Alignment.Center)
//                )
//                Box(
//                    modifier = Modifier
//                        .align(Alignment.BottomCenter)
////                                .offset(y = 75.dp)
//                ) {
//                    AsyncImage(
//                        model = R.drawable.kotak_xp,
//                        contentDescription = "",
//                        Modifier.size(30.dp)
//                    )
//                    Text(
//                        text = "2", color = Color.White,
//                        modifier = Modifier
//                            .align(Alignment.Center),
//                        style = MaterialTheme.typography.h5
//                    )
//                }
//            }
//            Spacer(modifier = Modifier.height(100.dp))
//            Text(text = "Bambang", style = MaterialTheme.typography.h5)
//        }
//    }
//}