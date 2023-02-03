package com.serdar.rickandmorty.data.repository

import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.data.dto.allcharacter.Result
import com.serdar.rickandmorty.data.dto.character.CharacterResponse


interface RickAndMortyRepository {
    suspend fun getRickAndMortyCharacter(characterNumber: String): NetworkResponse<CharacterResponse>

    suspend fun getRickAndMorty(): NetworkResponse<List<Result>>
}

