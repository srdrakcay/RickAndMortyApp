package com.serdar.rickandmorty.domain.mapper.allcharacter

import com.serdar.rickandmorty.domain.RickAndMortyEntity
import javax.inject.Inject
import com.serdar.rickandmorty.data.dto.allcharacter.Result


class RickAndMortyDomainListMapperImp @Inject constructor() :
    RickAndMortyListMapper<Result, RickAndMortyEntity> {
    override fun map(input: List<Result>?): List<RickAndMortyEntity> {
        return input?.map {
            RickAndMortyEntity(
                image = it.image,
                type = it.type,
                gender = it.gender,
                species = it.species,
                name = it.name,
                id=it.id
            )
        } ?: emptyList()
    }
}