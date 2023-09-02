package com.syafi.ecoquest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.syafi.ecoquest.presentation.add_postingan.AddPost
import com.syafi.ecoquest.presentation.challenge.ChallengeScreen
import com.syafi.ecoquest.presentation.edit_profil.EditProfilScreen
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
fun Navigation(navController: NavHostController, afterSplashDestination: String) {
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
        composable(Routes.HOME) {
            HomeScreen(navController = navController, email = "")
        }
        composable(
            Routes.HOME + "?email={email}",
            arguments = listOf(
                navArgument(name = "email") {
                    type = NavType.StringType
                }
            )
        ) {
            val email= it.arguments?.getString("email")
            email?.let {
                HomeScreen(navController = navController, email = email)
            }
        }
        composable(Routes.CHALLENGE + "?email={email}" + "?id={id}",
            arguments = listOf(
                navArgument(name = "email") {
                    type = NavType.StringType
                },
                navArgument(name = "id") {
                    type = NavType.IntType
                }
            )
        ) {
            val email = it.arguments?.getString("email")
            val id = it.arguments?.getInt("id")
            email?.let {
                if (id != null) {
                    ChallengeScreen(navController = navController, email = email, id = id)
                }
            }
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
            AddRutinitasScreen(navController)
        }
        composable(Routes.EDIT_PROFIL) {
            EditProfilScreen(navController)
        }
        composable(Routes.ADD_POSTINGAN) {
            AddPost(navController)
        }
    }
}