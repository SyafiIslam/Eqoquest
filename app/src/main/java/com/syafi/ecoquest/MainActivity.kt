package com.syafi.ecoquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import com.syafi.ecoquest.navigation.Navigation
import com.syafi.ecoquest.presentation.component.CustomScaffold
import com.syafi.ecoquest.presentation.component.NavBar
import com.syafi.ecoquest.presentation.splash.SplashViewModel
import com.syafi.ecoquest.ui.theme.EcoQuestTheme
import com.syafi.ecoquest.ui.theme.cream
import com.syafi.ecoquest.ui.theme.sage
import com.syafi.ecoquest.util.Routes
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var splashViewModel: SplashViewModel

    val showBottomBarList= listOf<String>(
        Routes.HOME,
        Routes.PERINGKAT,
        Routes.KOMUNITAS,
        Routes.HADIAH,
        Routes.PROFIL,
    )

    val showFabList= listOf<String>(
        Routes.HOME,
        Routes.KOMUNITAS,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            EcoQuestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val screen = splashViewModel._startDestination
                    val navController= rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()

                    CustomScaffold(
                        navController = navController,
                        showBottomBar = navBackStackEntry?.destination?.route in showBottomBarList,
                        showFab = navBackStackEntry?.destination?.route in showFabList,
                        onFabClick = {
                            when(navBackStackEntry?.destination?.route) {
                                Routes.HOME -> {
                                    navController.navigate(Routes.TAMBAH_RUTINITAS)
                                }
                                Routes.KOMUNITAS -> {
                                }
                            }
                        }
                    ) {
                        Navigation(navController = navController, screen)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        color = MaterialTheme.colors.sage
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EcoQuestTheme {
        Greeting("Android")
    }
}