package com.chimdike.greytest

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.chimdike.core.navigation.NavContainer
import com.chimdike.core.navigation.NavigationScreens
import com.chimdike.greytest.ui.theme.GreyTestTheme
import com.chimdike.home.ui.navigation.homeGraph
import com.chimdike.splash.ui.navigation.splashGraph
import com.chimdike.ui_compose.compose.theme.GreyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT))
        setContent {
            GreyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RootScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RootScreen(modifier: Modifier = Modifier) {
    Scaffold (
        modifier = Modifier.fillMaxSize(),
    ){
        val navController = rememberNavController()
        NavContainer(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = NavigationScreens.SplashScreen.route
        ) {
            splashGraph(navController)
            homeGraph(navController)
        }
    }

}
