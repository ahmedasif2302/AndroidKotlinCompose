package com.example.giftcard.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.giftcard.screens.home.HomeScreen
import com.example.giftcard.screens.login.LoginScreen
import com.example.giftcard.screens.splash.SplashScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) {
            SplashScreen()
        }
        composable(Routes.LOGIN) {
            LoginScreen()
        }
        composable(Routes.HOME) {
            HomeScreen()
        }
    }
}