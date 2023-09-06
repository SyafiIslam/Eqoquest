package com.syafi.ecoquest.presentation.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.syafi.ecoquest.model.DropDownData
import com.syafi.ecoquest.util.Routes

@Composable

fun DropdownRutinitas(navController: NavController, openDropdown: MutableState<Boolean>) {

    val dropdownItem= listOf(
        DropDownData(
            Icons.Default.Edit,
            "Edit"
        ),
        DropDownData(
            Icons.Default.Delete,
            "Delete"
        )
    )

    DropdownMenu(expanded = openDropdown.value, onDismissRequest = { openDropdown.value= false }) {
        dropdownItem.forEach {
            DropdownMenuItem(
                onClick = {
                    if (it.action === "Edit") {
                        openDropdown.value= false
                        navController.navigate(Routes.EDIT_RUTINITAS)
                    } else {
                        openDropdown.value= false
                    }
                }
            ) {
                Icon(imageVector = it.icon, contentDescription = "")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = it.action, style = MaterialTheme.typography.body1)
            }
        }
    }
}

@Composable
fun DialogUi(navController: NavController, openDropdown: MutableState<Boolean>) {
    Column(Modifier.padding(5.dp)) {
        Row(
            Modifier.clickable {
                openDropdown.value = false
            }
        ) {

        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            Modifier.clickable {
                openDropdown.value = false
            }
        ) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Delete", style = MaterialTheme.typography.body1)
        }
    }
}