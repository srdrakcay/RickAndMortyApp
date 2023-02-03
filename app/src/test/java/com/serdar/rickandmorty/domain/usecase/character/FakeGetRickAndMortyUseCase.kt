package com.serdar.rickandmorty.domain.usecase.character

import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.domain.constant.apiException
import com.serdar.rickandmorty.domain.constant.rickAndMortyEntityList
import com.serdar.rickandmorty.domain.usecase.getcharacter.GetRickAndMortyUseCase
import kotlinx.coroutines.flow.flow

class FakeGetRickAndMortyUseCase:GetRickAndMortyUseCase{

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }
    override fun invoke(characterNumber: String)=flow {
        emit(NetworkResponse.Loading)
        if (showError){
            emit(NetworkResponse.Error(apiException))
        }else
            emit(NetworkResponse.Success(rickAndMortyEntityList))
    }
}