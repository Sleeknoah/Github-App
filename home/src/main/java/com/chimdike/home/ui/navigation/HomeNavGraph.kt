package com.chimdike.home.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.chimdike.core.navigation.NavigationScreens
import com.chimdike.home.ui.home.compose.HomeScreen
import dagger.hilt.android.lifecycle.HiltViewModel

fun NavGraphBuilder.homeGraph(navController: NavHostController){
    navigation(startDestination = NavigationScreens.HomeScreen.route, route = NavigationScreens.HomeRoute.route){
        composable(route = NavigationScreens.HomeScreen.route){
            HomeScreen { route, args ->

            }
        }
//        composable(
//            route = "${NavigationScreens.DetailsScreen.route}/{login}",
//            arguments = listOf(
//                navArgument(name = "login"){
//                    type = NavType.StringType
//                }
//            )
//        ){ navBackStackEntry ->
//            DetailsScreen(userLogin = navBackStackEntry.arguments?.getString("login"))
//        }
    }
}
