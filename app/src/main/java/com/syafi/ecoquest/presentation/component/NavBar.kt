package com.syafi.ecoquest.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.syafi.ecoquest.model.NavBar
import com.syafi.ecoquest.R
import com.syafi.ecoquest.ui.theme.dark
import com.syafi.ecoquest.ui.theme.sage
import com.syafi.ecoquest.util.Routes

@Composable
fun NavBar(
    navController: NavController, bottomNavItem: List<NavBar> = listOf(
        NavBar(
            title = "Beranda",
            icon = painterResource(id = R.drawable.icon_home),
            route = Routes.HOME
        ),
        NavBar(
            title = "Peringkat",
            icon = painterResource(id = R.drawable.icon_leaderboard),
            route = Routes.PERINGKAT
        ),
        NavBar(
            title = "Komunitas",
            icon = painterResource(id = R.drawable.icon_komunitas),
            route = Routes.KOMUNITAS
        ),
        NavBar(
            title = "Hadiah",
            icon = painterResource(id = R.drawable.icon_reward),
            route = Routes.HADIAH
        ),
        NavBar(
            title = "Profil",
            icon = painterResource(id = R.drawable.icon_profile),
            route = Routes.PROFIL
        )
    )
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 10.dp
    ) {
        BottomNavigation() {
            bottomNavItem.forEach {
                BottomNavigationItem(
                    selected = navBackStackEntry?.destination?.route == it.route,
                    onClick = { navController.navigate(it.route) },
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
                                tint =
                                if (navBackStackEntry?.destination?.route == it.route)
                                    MaterialTheme.colors.dark
                                else
                                    MaterialTheme.colors.sage
                            )
                            Text(
                                text = it.title,
                                color =
                                if (navBackStackEntry?.destination?.route == it.route)
                                    MaterialTheme.colors.dark
                                else
                                    MaterialTheme.colors.sage
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