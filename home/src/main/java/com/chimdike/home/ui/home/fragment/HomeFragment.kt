package com.chimdike.home.ui.home.fragment

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chimdike.ui_compose.R
import com.chimdike.ui_compose.compose.GreTypography
import com.chimdike.ui_compose.compose.box.SelectionBox
import com.chimdike.ui_compose.compose.color.Background
import com.chimdike.ui_compose.compose.color.GithubCardGrey
import com.chimdike.ui_compose.compose.color.GithubCardPurple

const val REPOSITORY = 1
const val USERS = 2

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeFragment(
    onClick: (Int) -> Unit
){


    Scaffold(containerColor = Background){
        Column(modifier = Modifier.padding(24.dp)) {

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(id = R.string.home),
                style = GreTypography.headlineSmall.copy(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W700,
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(Modifier.fillMaxWidth()){
                SelectionBox(
                    modifier = Modifier.weight(1f),
                    color = GithubCardGrey,
                    icon = R.drawable.user,
                    text = stringResource(id = R.string.users)
                ){
                    onClick(USERS)
                }
                Spacer(modifier = Modifier.width(8.dp))
                SelectionBox(
                    modifier = Modifier.weight(1f),
                    color = GithubCardPurple,
                    icon = R.drawable.mobile,
                    text = stringResource(id = R.string.repositories)
                ){
                    onClick(REPOSITORY)
                }
            }
        }
    }
}