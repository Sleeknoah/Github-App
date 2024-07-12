package com.chimdike.splash.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.chimdike.core.navigation.NavigationScreens
import com.chimdike.splash.ui.splash.compose.SplashScreen

fun NavGraphBuilder.splashGraph(navController: NavHostController){
    navigation(startDestination = "splashScreen", route = NavigationScreens.SplashScreen.route){
        composable(route = "splashScreen"){
            SplashScreen{
                navController.popBackStack()
                navController.navigate(route = NavigationScreens.HomeScreen.route)
            }
        }
    }
}
