package com.serdar.rickandmorty.domain.usecase.getallcharacter

import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.domain.RickAndMortyEntity
import kotlinx.coroutines.flow.Flow

interface GetRickAndMortyCharacterUseCase {
    operator fun invoke(): Flow<NetworkResponse<List<RickAndMortyEntity>>>
}