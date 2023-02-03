package com.serdar.rickandmorty.ui.detail

import com.serdar.rickandmorty.domain.RickAndMortyEntity
import com.serdar.rickandmorty.domain.mapper.allcharacter.RickAndMortyListMapper
import javax.inject.Inject

class RickAndMortyDetailUiMapper @Inject constructor() :
    RickAndMortyListMapper<RickAndMortyEntity, DetailUiData> {
    override fun map(input: List<RickAndMortyEntity>?): List<DetailUiData> {
        return input?.map {
            DetailUiData(it.image, it.type,it.name ,it.species,it.id,it.gender)
        } ?: emptyList()
    }
}