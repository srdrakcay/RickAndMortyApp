package com.serdar.rickandmorty.domain.usecase.getcharacter

import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.data.repository.RickAndMortyRepository
import com.serdar.rickandmorty.domain.RickAndMortyEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.serdar.rickandmorty.data.dto.character.CharacterResponse
import com.serdar.rickandmorty.domain.mapper.allcharacter.RickAndMortyListMapper


import javax.inject.Inject

class GetRickAndMortyUseCaseImp @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository,
    private val characterListMapper: RickAndMortyListMapper<CharacterResponse, RickAndMortyEntity>
) : GetRickAndMortyUseCase {
    override fun invoke(characterNumber: String): Flow<NetworkResponse<List<RickAndMortyEntity>>> =
        flow {
            emit(NetworkResponse.Loading)
            when(val response =rickAndMortyRepository.getRickAndMortyCharacter(characterNumber)){
                is NetworkResponse.Error -> emit(response)
                NetworkResponse.Loading -> Unit
                is NetworkResponse.Success -> emit(
                    NetworkResponse.Success(
                        characterListMapper.map(listOf(response.result!!) )
                    )
                )
            }

        }


}