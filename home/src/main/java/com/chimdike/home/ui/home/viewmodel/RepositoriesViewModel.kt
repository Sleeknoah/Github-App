package com.chimdike.home.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chimdike.home.domain.entity.RepositoryEntityResult
import com.chimdike.home.domain.entity.UserEntityResult
import com.chimdike.home.domain.usecase.SearchRepositoriesUsecase
import com.chimdike.home.domain.usecase.SearchUserUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.annotation.concurrent.Immutable
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
    private val searchRepositoriesUsecase: SearchRepositoriesUsecase
): ViewModel(){
    private val _uiState = MutableStateFlow(RepositoryViewState.initial)
    val uiState: StateFlow<RepositoryViewState> = _uiState


    fun updateAppTextField(field: String){
        _uiState.update {
            it.copy(
                user = field,
            )
        }
    }

    fun searchRepositories(user: String){
        _uiState.update {
            it.copy(
                emptyState = true,
                isLoading = true,
            )
        }
        println(user)
        viewModelScope.launch(
            context = Dispatchers.IO
        ) {
           when  (val result = searchRepositoriesUsecase.execute(user)){
               is RepositoryEntityResult.Success ->{
                   _uiState.update {
                       it.copy(
                           isLoading = false,
                           entityResult = result,
                           emptyState = false,
                       )
                   }
               }
               is RepositoryEntityResult.Failure ->{
                   _uiState.update {
                       it.copy(
                           isLoading = false,
                           errorMessage = result.message,
                           emptyState = false,
                       )
                   }
               }
           }
        }
    }

}


@Immutable
data class RepositoryViewState(
    val user: String,
    val entityResult: RepositoryEntityResult.Success?,
    val errorMessage: String,
    val isLoading: Boolean,
    val emptyState: Boolean?
){
    companion object{
        val initial = RepositoryViewState(
            user = "",
            entityResult = null,
            errorMessage = "",
            isLoading = false,
            emptyState = true,
        )
    }
}