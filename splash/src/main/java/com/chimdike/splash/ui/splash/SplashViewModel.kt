package com.chimdike.splash.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.annotation.concurrent.Immutable
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(): ViewModel(){
    private val _viewState = MutableStateFlow<ViewState>(ViewState.initial)
    val uiState: StateFlow<ViewState> = _viewState

    init {
        viewModelScope.launch {
            runTimer()
        }
    }

    private suspend fun runTimer(){
        for (i in 1..3) {
            delay(1000L)
        }
        _viewState.update {
            it.copy(navigate = true)
        }
    }

}

@Immutable
data class ViewState(
    val navigate: Boolean?,
    ){
    companion object{
        val initial = ViewState(
            navigate = null,
        )
    }
}