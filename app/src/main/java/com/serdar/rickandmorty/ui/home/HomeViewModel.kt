package com.serdar.rickandmorty.ui.home

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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRickAndMortyCharacterUseCase: GetRickAndMortyUseCase,
    private val getRickAndMortyUseCase: GetRickAndMortyCharacterUseCase,
    private val rickAndMortyMapper: RickAndMortyListMapper<RickAndMortyEntity, HomeUiData>,
) : ViewModel() {


    // Backing field & encapsulation
    private val _rickAndMortyHomeUiState = MutableLiveData<HomeUiState>()
    val rickAndMortyHomeUiState: LiveData<HomeUiState> = _rickAndMortyHomeUiState

    fun getRickAndMortyCharacter(characterNumber: String) {

            getRickAndMortyCharacterUseCase(characterNumber).onEach {

                when (it) {
                    is NetworkResponse.Error -> {
                        // _rickAndMortyHomeUiState.value = ** MainThread
                        _rickAndMortyHomeUiState.postValue(HomeUiState.Error(R.string.error))
                    }
                    NetworkResponse.Loading -> {
                        _rickAndMortyHomeUiState.postValue(HomeUiState.Loading)
                    }
                    is NetworkResponse.Success -> {
                        _rickAndMortyHomeUiState.postValue(HomeUiState.Success(rickAndMortyMapper.map(it.result)))
                    }
                }
            }.launchIn(viewModelScope)

    }

    fun getRickAndMorty() {

            getRickAndMortyUseCase().onEach {
                delay(1000L)
                when (it) {
                    is NetworkResponse.Error -> {
                        // _rickAndMortyHomeUiState.value = ** MainThread
                        _rickAndMortyHomeUiState.postValue(HomeUiState.Error(R.string.error))
                    }
                    NetworkResponse.Loading -> {
                        _rickAndMortyHomeUiState.postValue(HomeUiState.Loading)
                    }
                    is NetworkResponse.Success -> {
                        _rickAndMortyHomeUiState.postValue(HomeUiState.Success(rickAndMortyMapper.map(it.result)))
                    }
                }
            }.launchIn(viewModelScope)
        }

}