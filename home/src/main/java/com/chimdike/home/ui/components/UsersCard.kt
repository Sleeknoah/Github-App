package com.chimdike.home.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.chimdike.ui_compose.compose.GreTypography
import com.chimdike.ui_compose.compose.ImageLoader
import com.chimdike.ui_compose.compose.NetworkImageLoader
import com.chimdike.ui_compose.compose.box.ImageCard
import com.chimdike.ui_compose.compose.box.SelectionBox
import com.chimdike.ui_compose.compose.color.GithubLightGrey
import com.chimdike.ui_compose.compose.color.UserTextColor

@Composable
fun UserCards(
    modifier: Modifier = Modifier,
    name:String,
    url:String,
    onClick: () -> Unit
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp).clickable { onClick() },
        border = BorderStroke(1.dp, GithubLightGrey),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 0.dp,
            pressedElevation= 0.dp,
            focusedElevation= 0.dp,
            hoveredElevation= 0.dp,
            draggedElevation= 0.dp,
            disabledElevation= 0.dp,
        )
    ){
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            ) {
            NetworkImageLoader(
                url = url,
                size = 50.dp,
                )

            Spacer(modifier = Modifier.width(24.dp))

            Text(
                text = name,
                style = GreTypography.bodyMedium.copy(
                    color = UserTextColor
                )
            )
        }
    }
}