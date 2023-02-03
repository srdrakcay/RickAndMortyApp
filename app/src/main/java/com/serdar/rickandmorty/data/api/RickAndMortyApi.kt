package com.serdar.rickandmorty.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import com.serdar.rickandmorty.data.dto.allcharacter.RickAndMortyResponse
import com.serdar.rickandmorty.data.dto.character.CharacterResponse

interface RickAndMortyApi {

@GET("character/{characterNumber}")
suspend fun getRickAndMortyCharacter(@Path("characterNumber") characterNumber: String) : CharacterResponse


@GET("character")
suspend fun getRickAndMorty() : RickAndMortyResponse
}