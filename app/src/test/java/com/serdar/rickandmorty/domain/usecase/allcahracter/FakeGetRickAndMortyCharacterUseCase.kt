package com.serdar.rickandmorty.domain.usecase.allcahracter

import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.domain.constant.apiException
import com.serdar.rickandmorty.domain.constant.rickAndMortyEntityList
import com.serdar.rickandmorty.domain.usecase.getallcharacter.GetRickAndMortyCharacterUseCase
import kotlinx.coroutines.flow.flow

class FakeGetRickAndMortyCharacterUseCase :GetRickAndMortyCharacterUseCase{

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    override fun invoke() = flow {
        emit(NetworkResponse.Loading)
        if (showError){
            emit(NetworkResponse.Error(apiException))
        }else
            emit(NetworkResponse.Success(rickAndMortyEntityList))
    }

}