package com.syafi.ecoquest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.syafi.ecoquest.presentation.add_postingan.AddPost
import com.syafi.ecoquest.presentation.challenge.ChallengeScreen
import com.syafi.ecoquest.presentation.edit_profil.EditProfilScreen
import com.syafi.ecoquest.presentation.edit_rutinitas.EditRutinitas
import com.syafi.ecoquest.presentation.hadiah.RewardScreen
import com.syafi.ecoquest.presentation.home.HomeScreen
import com.syafi.ecoquest.presentation.komunitas.CommunityScreen
import com.syafi.ecoquest.presentation.login.LoginScreen
import com.syafi.ecoquest.presentation.login.RegisterScreen
import com.syafi.ecoquest.presentation.peringkat.LeaderBoardScreen
import com.syafi.ecoquest.presentation.profil.ProfileScreen
import com.syafi.ecoquest.presentation.splash.SplashScreen
import com.syafi.ecoquest.presentation.tambah_rutinitas.AddRutinitasScreen
import com.syafi.ecoquest.presentation.welcome.WelcomeScreen
import com.syafi.ecoquest.util.Routes

@Composable
fun Navigation(
    navController: NavHostController,
    afterSplashDestination: String,
    _email: MutableState<String>
) {
    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) {
            SplashScreen(navController = navController, afterSplashDestination)
        }
        composable(Routes.WELCOME) {
            WelcomeScreen(navController = navController)
        }
        composable(Routes.LOGIN) {
            LoginScreen(navController = navController)
        }
        composable(Routes.REGISTER) {
            RegisterScreen(navController = navController)
        }

        composable(
            Routes.HOME + "?email={email}",
            arguments = listOf(
                navArgument(name = "email") {
                    type = NavType.StringType
                }
            )
        ) {
            val email = it.arguments?.getString("email")
            email?.let {
                _email.value= email
                HomeScreen(navController = navController, email = email)
            }
        }
        composable(Routes.CHALLENGE) {
            ChallengeScreen(navController = navController, email = _email)
        }
        composable(Routes.PERINGKAT) {
            LeaderBoardScreen()
        }
        composable(Routes.KOMUNITAS) {
            CommunityScreen()
        }
        composable(Routes.HADIAH) {
            RewardScreen()
        }
        composable(Routes.PROFIL) {
            ProfileScreen(navController)
        }
        composable(Routes.TAMBAH_RUTINITAS) {
            AddRutinitasScreen(navController, _email.value)
        }
        composable(Routes.EDIT_RUTINITAS) {
            EditRutinitas(navController = navController, _email.value)
        }
        composable(Routes.EDIT_PROFIL) {
            EditProfilScreen(navController)
        }
        composable(Routes.ADD_POSTINGAN) {
            AddPost(navController)
        }
    }
}