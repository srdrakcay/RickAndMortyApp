package com.serdar.rickandmorty.ui.home

import androidx.annotation.StringRes

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val data: List<HomeUiData>) : HomeUiState()
    data class Error(@StringRes val message: Int) : HomeUiState()
}