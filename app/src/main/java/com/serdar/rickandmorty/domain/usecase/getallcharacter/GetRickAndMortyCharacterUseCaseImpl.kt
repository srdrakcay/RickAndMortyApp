package com.serdar.rickandmorty.domain.usecase.getallcharacter

import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.data.repository.RickAndMortyRepository
import com.serdar.rickandmorty.domain.RickAndMortyEntity
import com.serdar.rickandmorty.domain.mapper.allcharacter.RickAndMortyListMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.serdar.rickandmorty.data.dto.allcharacter.Result

import javax.inject.Inject

class GetRickAndMortyCharacterUseCaseImpl @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository,
    private val rickAndMortyListMapper: RickAndMortyListMapper<Result, RickAndMortyEntity>
) : GetRickAndMortyCharacterUseCase {

override fun invoke(): Flow<NetworkResponse<List<RickAndMortyEntity>>> =
    flow {
        emit(NetworkResponse.Loading)
        when(val response =rickAndMortyRepository.getRickAndMorty()){
            is NetworkResponse.Error -> emit(response)
            NetworkResponse.Loading -> Unit
            is NetworkResponse.Success -> emit(
                NetworkResponse.Success(rickAndMortyListMapper.map(response.result)
                )
            )
        }
    }
}