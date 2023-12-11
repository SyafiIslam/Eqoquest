package com.syafi.ecoquest.presentation.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.syafi.ecoquest.R
import com.syafi.ecoquest.model.Rutinitas
import com.syafi.ecoquest.presentation.component.CustomLinearProgressBar
import com.syafi.ecoquest.ui.theme.cream
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.ui.theme.green
import com.syafi.ecoquest.ui.theme.sage
import com.syafi.ecoquest.util.Routes

@Composable
fun RutinitasItem(navController: NavController, rutinitas: Rutinitas, index: Int) {

    var isChecked by remember {
        mutableStateOf(false)
    }

    var openDropDown = remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .clickable {
            },
        elevation = 3.dp,
        backgroundColor =
        if (index % 2 == 0)
            MaterialTheme.colors.sage
        else
            MaterialTheme.colors.cream,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = rutinitas.title,
                style = MaterialTheme.typography.body1,
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked = !isChecked
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.White,
                        uncheckedColor = Color.White,
                        checkmarkColor = MaterialTheme.colors.dark,
                    )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    painterResource(id = R.drawable.three_dot),
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        openDropDown.value= true
                    }
                )
                if (openDropDown.value) {
                    DropdownRutinitas(navController, openDropDown)
                }
            }
        }
    }
}