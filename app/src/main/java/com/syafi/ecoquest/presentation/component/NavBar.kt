package com.syafi.ecoquest.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.syafi.ecoquest.model.NavBar
import com.syafi.ecoquest.R
import com.syafi.ecoquest.ui.theme.green
import com.syafi.ecoquest.ui.theme.sage

@Composable
fun NavBar(
    navController: NavController, bottomNavItem: List<NavBar> = listOf(
        NavBar(
            title = "Beranda",
            icon = painterResource(id = R.drawable.icon_home),
        ),
        NavBar(
            title = "Peringkat",
            icon = painterResource(id = R.drawable.icon_leaderboard)
        ),
        NavBar(
            title = "Hadiah",
            icon = painterResource(id = R.drawable.icon_reward)
        ),
        NavBar(
            title = "Profil",
            icon = painterResource(id = R.drawable.icon_profile)
        )
    )
) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.White),
//        elevation = 5.dp
//    ) {
//        BottomNavigation(
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            bottomNavItem.forEach {
//                BottomNavigationItem(
//                    selected = false,
//                    onClick = { /*TODO*/ },
//                    icon = {
//                        Column(
//                            modifier = Modifier.padding(8.dp),
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//                            Icon(
//                                painter = it.icon,
//                                contentDescription = it.title,
//                                tint = MaterialTheme.colors.sage
//                            )
//                            Text(
//                                text = it.title,
//                                color = MaterialTheme.colors.sage
//                            )
//                        }
//                    },
//                )
//            }
//        }
//
//    }
//}
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 10.dp
    ) {
        BottomNavigation() {
            bottomNavItem.forEach {
                BottomNavigationItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.White),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = it.icon,
                                contentDescription = it.title,
                                tint = MaterialTheme.colors.sage,
//                                modifier = Modifier
//                                    .align(Alignment.Center)
                            )
                            Text(
                                text = it.title,
                                color = MaterialTheme.colors.sage,
//                                modifier = Modifier.align(Alignment.BottomCenter)
                            )
                        }
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Design() {

}