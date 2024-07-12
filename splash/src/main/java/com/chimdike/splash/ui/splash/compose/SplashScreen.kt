package com.chimdike.splash.ui.splash.compose

import android.annotation.SuppressLint
import android.widget.ProgressBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chimdike.splash.ui.splash.SplashViewModel
import com.chimdike.ui_compose.R
import com.chimdike.ui_compose.compose.ImageLoader

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SplashScreen(
    viewModel: SplashViewModel = viewModel(),
    onNavigate: () -> Unit
){
    val uiState = viewModel.uiState.collectAsState().value
    if(uiState.navigate == true){
        onNavigate()
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White

    ){
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            ImageLoader(
                resource = R.drawable.github,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.height(24.dp))

        }
    }
}