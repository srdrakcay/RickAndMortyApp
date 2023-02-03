package com.serdar.rickandmorty.domain.usecase.getcharacter

import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.domain.RickAndMortyEntity
import kotlinx.coroutines.flow.Flow

interface GetRickAndMortyUseCase {
    operator fun invoke(characterNumber: String): Flow<NetworkResponse<List<RickAndMortyEntity>>>


}