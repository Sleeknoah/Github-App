package com.chimdike.ui_compose.compose

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.chimdike.ui_compose.compose.color.SearchText

val GreTypography = GreyTypo(
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    searchTextFieldText = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 12.sp,
        color = SearchText
    ),
    buttonStyle = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 10.sp
    ),
)
val GreyTypography = Typography(
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
)

data class GreyTypo(
    val bodyMedium: TextStyle,
    val headlineSmall: TextStyle,
    val searchTextFieldText: TextStyle,
    val buttonStyle: TextStyle,
)