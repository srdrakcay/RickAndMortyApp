package com.serdar.rickandmorty.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serdar.rickandmorty.R
import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.domain.RickAndMortyEntity
import com.serdar.rickandmorty.domain.mapper.allcharacter.RickAndMortyListMapper
import com.serdar.rickandmorty.domain.usecase.getallcharacter.GetRickAndMortyCharacterUseCase
import com.serdar.rickandmorty.domain.usecase.getcharacter.GetRickAndMortyUseCase
import com.serdar.rickandmorty.ui.home.HomeUiData
import com.serdar.rickandmorty.ui.home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getRickAndMortyCharacterUseCase: GetRickAndMortyUseCase,
    private val rickAndMortyDetailMapper: RickAndMortyListMapper<RickAndMortyEntity, DetailUiData>,
    )
    : ViewModel() {


    // Backing field & encapsulation
    private val _rickAndMortyDetailUiState = MutableLiveData<DetailUiState>()
    val rickAndMortyDetailUiState: LiveData<DetailUiState> = _rickAndMortyDetailUiState

    fun getRickAndMortyCharacter(characterNumber: String) {

        getRickAndMortyCharacterUseCase(characterNumber).onEach {

            when (it) {
                is NetworkResponse.Error -> {
                    // _rickAndMortyHomeUiState.value = ** MainThread
                    _rickAndMortyDetailUiState.postValue(DetailUiState.Error(R.string.error))
                }
                NetworkResponse.Loading -> {
                    _rickAndMortyDetailUiState.postValue(DetailUiState.Loading)
                }
                is NetworkResponse.Success -> {
                    _rickAndMortyDetailUiState.postValue(DetailUiState.Success(rickAndMortyDetailMapper.map(it.result)))
                }
            }
        }.launchIn(viewModelScope)

    }
}