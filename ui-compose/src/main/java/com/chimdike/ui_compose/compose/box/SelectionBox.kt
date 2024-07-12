package com.chimdike.ui_compose.compose.box

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.chimdike.ui_compose.compose.GreTypography
import com.chimdike.ui_compose.compose.ImageLoader
import com.chimdike.ui_compose.compose.color.GithubFadedWhite
import com.chimdike.ui_compose.compose.color.GithubLightGrey

@Composable
fun SelectionBox(
    modifier: Modifier = Modifier,
    color: Color,
    @DrawableRes icon: Int,
    text: String,
    onClick: () -> Unit
){
    Card(
        modifier = modifier.fillMaxWidth().clickable(onClick = onClick),
        border = BorderStroke(1.dp, GithubLightGrey),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = color,
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
        Column(modifier = Modifier.padding(12.dp)) {
            ImageCard(icon = icon)
            Spacer(modifier = Modifier.height(36.dp))
            Text(
                text = text,
                style = GreTypography.bodyMedium.copy(
                    color = Color.Black
                )
            )
        }
    }
}

@Composable
fun ImageCard(
    @DrawableRes icon: Int
){
    Card(
        shape = RoundedCornerShape(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = GithubFadedWhite,
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
        ImageLoader(modifier = Modifier.padding(8.dp), resource = icon)
    }
}