package com.serdar.rickandmorty.domain.mapper.allcharacter



interface RickAndMortyMapper<I, O> {
    fun map(input: I?): O
}

