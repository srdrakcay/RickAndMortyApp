package com.serdar.rickandmorty.ui.detail

import androidx.annotation.StringRes

sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(val data: List<DetailUiData>) : DetailUiState()
    data class Error(@StringRes val message: Int) : DetailUiState()
}