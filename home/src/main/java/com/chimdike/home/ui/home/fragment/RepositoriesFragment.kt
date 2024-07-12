package com.chimdike.home.ui.home.fragment

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chimdike.home.ui.components.RepositoryCards
import com.chimdike.home.ui.home.viewmodel.RepositoriesViewModel
import com.chimdike.home.ui.home.viewmodel.RepositoryViewState
import com.chimdike.ui_compose.R
import com.chimdike.ui_compose.compose.GreTypography
import com.chimdike.ui_compose.compose.ImageLoader
import com.chimdike.ui_compose.compose.color.Background
import com.chimdike.ui_compose.compose.color.SearchTextUnfocusedContainerColor
import com.chimdike.ui_compose.compose.widgets.AppTextField

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RepositoryFragment(
    viewModel: RepositoriesViewModel = hiltViewModel()
){
    val uiState = viewModel.uiState.collectAsState().value
    Scaffold(containerColor = Background){
        Column(modifier = Modifier.padding(
            top = 24.dp,
            start = 24.dp,
            end = 24.dp,
        )) {

            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(id = R.string.repositories),
                style = GreTypography.headlineSmall.copy(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W700,
                )
            )

            Spacer(modifier = Modifier.height(24.dp))
            Box(Modifier.height(TextFieldDefaults.MinHeight)) {
                UpperBand(viewModel, uiState)
            }
            Box(Modifier.weight(9f)) {
                when (uiState.emptyState) {
                    true -> {
                        InitialStateScreen(uiState = uiState, errorState = true)
                    }
                    false -> {
                        if(uiState.entityResult != null && uiState.entityResult.result.items.isNotEmpty()){
                            RepositorySuccessLayout(uiState = uiState, viewModel = viewModel)
                        }
                        if(uiState.entityResult != null && uiState.entityResult.result.items.isEmpty()){
                            InitialStateScreen(
                                uiState = uiState,
                                isEmpty = true,
                                errorState = true,
                            )
                        }
                        if(uiState.errorMessage.isNotEmpty()){
                            InitialStateScreen(
                                uiState = uiState,
                                errorState = true,
                            )
                        }
                    }
                    null ->  InitialStateScreen(uiState = uiState, errorState = true)
                }

            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
private fun UpperBand(viewModel: RepositoriesViewModel, uiState: RepositoryViewState) {

    AppTextField(
        value = uiState.user,
        placeholder = stringResource(id = R.string.search_for_repositories),
        borderColor = if(uiState.user.isEmpty()) SearchTextUnfocusedContainerColor else Color.Black,
        leadingRes = R.drawable.search_normal,
        onValueChange = {
            viewModel.updateAppTextField(it)
        }
    ) {
        if(uiState.user.isNotEmpty()){
            viewModel.searchRepositories(uiState.user)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InitialStateScreen(
    uiState: RepositoryViewState,
    modifier: Modifier = Modifier,
    isEmpty: Boolean = false,
    errorState: Boolean = false
){
    var descriptionText = ""
    if(uiState.errorMessage.isNotEmpty()){
        descriptionText = uiState.errorMessage
    }
    if(uiState.entityResult == null && uiState.errorMessage.isEmpty()){
        descriptionText = "Search Github for repositories..."
    }
    if(isEmpty){
        descriptionText = "We’ve searched the ends of the earth and we’ve not found this repository, please try again"
    }
    if(uiState.isLoading){
        descriptionText = "Searching for github repositories..."
    }

    if(errorState){
        descriptionText = uiState.errorMessage
    }


    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageLoader(resource = R.drawable.empty_state)
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = descriptionText,
            style = GreTypography.bodyMedium.copy(
                color = Color.Black,
                fontWeight = FontWeight.W500
            ),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(12.dp))
        if(uiState.isLoading)
            CircularProgressIndicator(
            modifier = Modifier.size(50.dp),
            color = Color.Black,
            strokeWidth =  5.dp
        )
    }
}

@Composable
internal fun RepositorySuccessLayout(
    uiState: RepositoryViewState,
    viewModel: RepositoriesViewModel,
){
    uiState.entityResult?.let {
        val repoList = it.result.items
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(top = 12.dp)) {
                    items(items = repoList){ repo ->
                        RepositoryCards(item = repo)
                    }
        }
    }
}