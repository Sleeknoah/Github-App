package com.chimdike.ui_compose.compose.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chimdike.ui_compose.compose.GreTypography
import com.chimdike.ui_compose.compose.box.ImageCard
import com.chimdike.ui_compose.compose.color.GithubLightGrey

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    text: String,
    onClick: () -> Unit
){
    Card(
        modifier = modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = color,
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 4.dp,
            pressedElevation= 0.dp,
            focusedElevation= 0.dp,
            hoveredElevation= 0.dp,
            draggedElevation= 0.dp,
            disabledElevation= 0.dp,
        )
    ){

        Box(
           modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = text,
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center,
                style = GreTypography.buttonStyle.copy(
                    color = Color.White
                )
            )
        }
    }
}