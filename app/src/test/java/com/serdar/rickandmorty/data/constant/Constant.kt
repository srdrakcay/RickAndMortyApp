package com.serdar.rickandmorty.data.constant

import androidx.annotation.VisibleForTesting
import com.serdar.rickandmorty.data.dto.character.CharacterResponse
import com.serdar.rickandmorty.data.dto.character.Location
import com.serdar.rickandmorty.data.dto.character.Origin


const val SAMPLE_RESPONSE_FILE_NAME = "RickAndMorty.json"
const val CHARACTER_NUMBER = "1"
const val CHARACTER_PATH = "/character/1"
const val ALL_CHARACTER_PATH = "/character"
const val CHARACTER_NAME = "Rick Sanchez"

val apiException = Exception("Something went wrong")

@VisibleForTesting
val characterResponseDto = CharacterResponse(
    name = "Rick Sanchez",
    created = "serdar",
    species = "Human",
    status = "Alive",
    episode = emptyList(),
    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
    location = Location("Citadel of Ricks", "https://rickandmortyapi.com/api/location/3"),
    gender = "Male",
    origin = Origin("Earth (C-137)", "https://rickandmortyapi.com/api/location/1"),
    type = "",
    id = 1,
    url = "https://rickandmortyapi.com/api/character/1"
)

@VisibleForTesting
val characterResponseList= mutableListOf(characterResponseDto)


