package com.chimdike.home.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chimdike.home.domain.entity.RepositoryItemResult
import com.chimdike.ui_compose.compose.GreTypography
import com.chimdike.ui_compose.compose.ImageLoader
import com.chimdike.ui_compose.compose.NetworkImageLoader
import com.chimdike.ui_compose.compose.color.GithubLightGrey
import com.chimdike.ui_compose.compose.color.UserLoginTextColor
import com.chimdike.ui_compose.R

@Composable
fun RepositoryCards(
    modifier: Modifier = Modifier,
    item :RepositoryItemResult
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
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

        Column(modifier = Modifier.fillMaxWidth()) {
            TitleComposable(item)
            Spacer(modifier = Modifier.height(4.dp))
            DescriptionComposable(bio = item.description)
            Spacer(modifier = Modifier.height(12.dp))
            if(item.topics.isNotEmpty())
                TopicsGridComposable(topics = item.topics)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
private fun TitleComposable(item: RepositoryItemResult) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box {
            NetworkImageLoader(
                url = item.owner.avatarUrl,
                size = 30.dp,
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(
                text = "${item.owner.login}/",
                style = GreTypography.bodyMedium.copy(
                    fontSize = 12.sp,
                    color = UserLoginTextColor,
                    fontWeight = FontWeight.W400,
                )
            )
            Text(
                text = item.name,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = GreTypography.bodyMedium.copy(
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W600,
                )
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageLoader(resource = R.drawable.star)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "${item.stargazersCount}",
                style = GreTypography.searchTextFieldText.copy(
                    fontSize = 10.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W500,
                )
            )
        }
        if (item.language.isNotEmpty())
            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.Green)
                ) {
                    Spacer(modifier = Modifier.size(8.dp))
                }
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = item.language,
                    style = GreTypography.searchTextFieldText.copy(
                        fontSize = 10.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.W500,
                    )
                )
            }
    }
}

@Composable
fun DescriptionComposable(bio: String){
    Text(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = bio,
        style = GreTypography.searchTextFieldText.copy(
            fontSize = 12.sp,
            color = Color.Black,
            fontWeight = FontWeight.W400,
        )
    )
}

@Composable
fun TopicsComposable(topic: String){
    Card(
        modifier = Modifier.padding(2.dp),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE8F9FF),
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

        Box(modifier = Modifier.padding(8.dp)) {
            Text(
                text = topic,
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center,
                style = GreTypography.buttonStyle.copy(
                    fontSize = 10.sp,
                    color = Color(0xFF408AAA)
                )
            )
        }
    }
}
@Composable
fun TopicsGridComposable(topics: List<String>){
    Box(modifier = Modifier.padding(horizontal = 16.dp)) {
        val grid = topics.chunked(3)

        Column{
            grid.forEach{ topicList ->
                Row {
                    for (i in topicList.indices){
                        TopicsComposable(topic = topicList[i])
                    }
                }
            }
        }
    }
}