package com.serdar.rickandmorty.data.source

import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.data.api.RickAndMortyApi
import com.serdar.rickandmorty.data.dto.allcharacter.Result
import com.serdar.rickandmorty.data.dto.character.CharacterResponse
import javax.inject.Inject

class RemoteDataSourceImp  @Inject constructor(private val rickAndMortyApi: RickAndMortyApi):RemoteDataSource {
    override suspend fun getRickAndMortyCharacter(characterNumber: String): NetworkResponse<CharacterResponse> =
        try { val response = rickAndMortyApi.getRickAndMortyCharacter(characterNumber)
            NetworkResponse.Success(response);
        } catch (e: Exception) {
            NetworkResponse.Error(e)
        }

    override suspend fun getRickAndMorty(): NetworkResponse<List<Result>> =
        try {
            val response = rickAndMortyApi.getRickAndMorty()
            NetworkResponse.Success(response.results)
        } catch (e: Exception) {
            NetworkResponse.Error(e)
        }
}
