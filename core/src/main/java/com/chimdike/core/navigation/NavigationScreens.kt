package com.chimdike.core.navigation


sealed class NavigationScreens(val route: String){
    object SplashScreen: NavigationScreens(route = "splash")
    object HomeScreen: NavigationScreens(route = "home")
    object HomeRoute: NavigationScreens(route = "home_route")
    object DetailsScreen: NavigationScreens(route = "details")
}


object HomeScreenPage
data class DetailsScreen(
    val name: String
)