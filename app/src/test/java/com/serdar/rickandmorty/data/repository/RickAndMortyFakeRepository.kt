package com.serdar.rickandmorty.data.repository

import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.data.constant.apiException
import com.serdar.rickandmorty.data.constant.characterResponseList
import com.serdar.rickandmorty.data.dto.allcharacter.Result
import com.serdar.rickandmorty.data.dto.character.CharacterResponse
import com.serdar.rickandmorty.domain.mapper.allcharacter.RickAndMortyDomainListMapperImp
import com.serdar.rickandmorty.ui.home.RickAndMortyUiMapperImpl

class RickAndMortyFakeRepository() :RickAndMortyRepository {

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    override suspend fun getRickAndMortyCharacter(characterNumber: String): NetworkResponse<CharacterResponse> {
        return if (showError){
            NetworkResponse.Error(apiException)
        }else{
            NetworkResponse.Success(characterResponseList[0])
        }
    }

    override suspend fun getRickAndMorty(): NetworkResponse<List<Result>> {
        TODO("Not yet implemented")
    }
}