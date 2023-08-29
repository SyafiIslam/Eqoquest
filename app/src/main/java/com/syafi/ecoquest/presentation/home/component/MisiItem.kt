package com.syafi.ecoquest.presentation.home.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syafi.ecoquest.data.misiList
import com.syafi.ecoquest.model.Misi
import com.syafi.ecoquest.ui.theme.cream
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.ui.theme.sage

@Composable
fun MisiItem(misi: Misi, index: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        backgroundColor =
            if (index % 2 == 0) MaterialTheme.colors.sage
            else MaterialTheme.colors.cream,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
           Text(
               modifier = Modifier.weight(0.5f),
               text = misi.title,
               style = MaterialTheme.typography.body1
           )

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "+${misi.bonus} exp",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${misi.timer} h",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.dark,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun Design() {
    val misi = misiList[0]
    MisiItem(misi, 0)
}