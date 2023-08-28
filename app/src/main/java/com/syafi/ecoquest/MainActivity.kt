package com.syafi.ecoquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.syafi.ecoquest.navigation.Navigation
import com.syafi.ecoquest.presentation.splash.SplashViewModel
import com.syafi.ecoquest.ui.theme.EcoQuestTheme
import com.syafi.ecoquest.ui.theme.cream
import com.syafi.ecoquest.ui.theme.sage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcoQuestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val screen = splashViewModel._startDestination
                    val navController= rememberNavController()
                    Navigation(navController = navController, afterSplashDestination = screen)
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
            .padding(6.dp)
            .background(MaterialTheme.colors.sage)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EcoQuestTheme {
        Greeting("Android")
    }
}