package com.chimdike.home.ui.home.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chimdike.home.ui.home.fragment.HomeFragment
import com.chimdike.home.ui.home.fragment.RepositoryFragment
import com.chimdike.home.ui.home.fragment.UsersFragment
import com.chimdike.home.ui.home.model.navItems
import com.chimdike.home.ui.home.viewmodel.HomeViewModel
import com.chimdike.ui_compose.compose.ImageLoader

const val HOME = 0
const val REPOSITORY = 1
const val USERS = 2

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigate: (route: String, arg: String) -> Unit,
){
    var selectedNavIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
            ) {
                navItems.forEachIndexed { index, navigationItem ->
                    NavigationBarItem(
                        selected = index == selectedNavIndex,
                        label = {
                            val weight = if(index == selectedNavIndex) FontWeight.W600 else FontWeight.W400
                            Text(text = navigationItem.text,
                                style = TextStyle(fontWeight = weight)
                            )
                        },
                        onClick = { selectedNavIndex = index },
                        icon = {
                           if(selectedNavIndex == index)
                               ImageLoader(resource = navigationItem.selectedIcon) else
                               ImageLoader(resource = navigationItem.unSelectedIcon)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.White,
                            selectedTextColor = Color.Black,
                            unselectedTextColor = Color.Black,
                        )
                    )
                }
            }
        }
    ){
        Box(Modifier.padding(bottom = it.calculateBottomPadding())) {
            when (selectedNavIndex) {
                HOME -> {
                    HomeFragment{navRoute ->
                        if(selectedNavIndex != navRoute) selectedNavIndex = navRoute
                    }
                }
                REPOSITORY -> {
                    RepositoryFragment()
                }
                else -> {
                    UsersFragment(viewModel)
                }
            }
        }
    }
}