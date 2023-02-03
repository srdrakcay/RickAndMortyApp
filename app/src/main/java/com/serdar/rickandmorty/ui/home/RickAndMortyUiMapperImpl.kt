package com.serdar.rickandmorty.ui.home

import com.serdar.rickandmorty.domain.RickAndMortyEntity
import com.serdar.rickandmorty.domain.mapper.allcharacter.RickAndMortyListMapper
import javax.inject.Inject
import javax.inject.Named


class RickAndMortyUiMapperImpl @Inject constructor() :
    RickAndMortyListMapper<RickAndMortyEntity, HomeUiData> {
    override fun map(input: List<RickAndMortyEntity>?): List<HomeUiData> {
        return input?.map {
            HomeUiData(it.image, it.type,it.name ,it.species,it.id)
        } ?: emptyList()
    }
}