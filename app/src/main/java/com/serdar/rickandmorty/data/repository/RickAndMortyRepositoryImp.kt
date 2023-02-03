package com.serdar.rickandmorty.data.repository

import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.data.source.RemoteDataSource
import com.serdar.rickandmorty.di.coroutine.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import com.serdar.rickandmorty.data.dto.allcharacter.Result
import com.serdar.rickandmorty.data.dto.character.CharacterResponse


class RickAndMortyRepositoryImp @Inject constructor(private val remoteDataSource: RemoteDataSource,
@IoDispatcher
private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO):RickAndMortyRepository {
    override suspend fun getRickAndMortyCharacter(characterNumber: String): NetworkResponse<CharacterResponse> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getRickAndMortyCharacter(characterNumber)
            } catch (e: Exception) {
                NetworkResponse.Error(e)
            }
        }

    override suspend fun getRickAndMorty(): NetworkResponse<List<Result>> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getRickAndMorty()
            } catch (e: Exception) {
                NetworkResponse.Error(e)
            }
        }
    }

