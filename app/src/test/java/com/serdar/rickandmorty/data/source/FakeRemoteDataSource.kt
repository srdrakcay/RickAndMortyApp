package com.serdar.rickandmorty.data.source

import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.data.constant.characterResponseList
import com.serdar.rickandmorty.data.dto.allcharacter.Result
import com.serdar.rickandmorty.data.dto.character.CharacterResponse

class FakeRemoteDataSource : RemoteDataSource {

    private var showError = false

    fun updateShowError(showError: Boolean) {
        this.showError = showError
    }

    override suspend fun getRickAndMortyCharacter(characterNumber: String): NetworkResponse<CharacterResponse> {
        NetworkResponse.Loading
        return if (showError.not()) {
            NetworkResponse.Success(characterResponseList[0])
        } else {
            NetworkResponse.Error(apiException)
        }
    }

    override suspend fun getRickAndMorty(): NetworkResponse<List<Result>> {
        TODO("Not yet implemented")
    }


}