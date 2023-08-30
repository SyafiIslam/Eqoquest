package com.syafi.ecoquest.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.syafi.ecoquest.data.misiList
import com.syafi.ecoquest.model.Misi
import com.syafi.ecoquest.presentation.component.CustomLinearProgressBar
import com.syafi.ecoquest.ui.theme.cream
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.ui.theme.green
import com.syafi.ecoquest.ui.theme.sage

@Composable
fun MisiItem(misi: Misi, index: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        elevation = 4.dp,
        backgroundColor =
            if (index % 2 == 0) MaterialTheme.colors.sage
            else MaterialTheme.colors.cream,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = misi.title,
                    style = MaterialTheme.typography.body1,
                )
                Text(
                    text = "+${misi.bonus} exp",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

//            LinearProgressIndicator(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clip(CircleShape),
//                color =
//                    if (index % 2 == 0) MaterialTheme.colors.dark
//                    else MaterialTheme.colors.green,
//                backgroundColor = Color.White,
//                progress = misi.progress
//            )

            CustomLinearProgressBar(
                progress = misi.progress,
                color =
                if (index % 2 == 0)
                    MaterialTheme.colors.dark
                else
                    MaterialTheme.colors.green,
            )

            Text(
                text = "Tersisa ${misi.timer}j",
                style = MaterialTheme.typography.body2,
                fontSize = 10.sp,
                color =
                    if (index % 2 == 0) MaterialTheme.colors.dark
                    else MaterialTheme.colors.green
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun Design() {
    val misi = misiList[0]
    MisiItem(misi, 0)
}