package com.serdar.rickandmorty.domain.mapper.character

import com.serdar.rickandmorty.data.dto.character.CharacterResponse
import com.serdar.rickandmorty.domain.RickAndMortyEntity
import com.serdar.rickandmorty.domain.mapper.allcharacter.RickAndMortyListMapper
import javax.inject.Inject


class CharacterDomainListMapper @Inject constructor() :
    RickAndMortyListMapper<CharacterResponse, RickAndMortyEntity> {
    override fun map(input: List<CharacterResponse>?): List<RickAndMortyEntity> {
        return input?.map {
            RickAndMortyEntity(
                image = it.image,
                type = it.type,
                gender = it.gender,
                species =it.species,
                name = it.name,
                id=it.id
            )
        } ?: emptyList()
    }


}