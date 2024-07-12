package com.chimdike.ui_compose.compose.widgets

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chimdike.ui_compose.R
import com.chimdike.ui_compose.compose.GreTypography
import com.chimdike.ui_compose.compose.ImageLoader
import com.chimdike.ui_compose.compose.color.Background
import com.chimdike.ui_compose.compose.color.SearchTextUnfocusedContainerColor

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    value: String?,
    singleLine: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle? = null,
    placeholder: String,
    borderColor: Color,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    interactionSource: MutableInteractionSource? = null,
    onValueChange: (value: String) -> Unit,
    visualTransformation: VisualTransformation? = null,
    leadingRes: Int? = null,
    trailingRes: @Composable (() -> Unit)? = null,
    backgroundColor: Color = Color.Transparent,
    isSecret: Boolean = false,
    trailingClicked: (() -> Unit),
) {

    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(size = 4.dp)
            )
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        TextField(
            value = value!!,
            readOnly = readOnly,
            modifier = Modifier
                .weight(4f)
                .background(color = Background),
            singleLine = singleLine,
            textStyle = textStyle ?: LocalTextStyle.current,
            placeholder = {
                Text(
                    text = placeholder,
                    style = GreTypography.searchTextFieldText
                )
            },
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            interactionSource = interactionSource ?: remember { MutableInteractionSource() },
            onValueChange = onValueChange,
            visualTransformation = if (isSecret) PasswordVisualTransformation() else VisualTransformation.None,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                cursorColor = SearchTextUnfocusedContainerColor,
            ),
            leadingIcon = {
                if (leadingRes != null) {
                    ImageLoader(resource = leadingRes)
                }
            },
        )

        PrimaryButton(
            modifier = Modifier
                .fillMaxHeight()
                .weight(2f)
                .padding(8.dp),
            text = stringResource(R.string.search),
            onClick = trailingClicked,
        )
    }


}