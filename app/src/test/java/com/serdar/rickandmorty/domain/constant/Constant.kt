package com.serdar.rickandmorty.domain.constant

import com.serdar.rickandmorty.domain.RickAndMortyEntity

val apiException = Exception("Something went wrong")

val rickAndMortyEntity=RickAndMortyEntity(
    name ="Rick Sanchez" ,
    type = "",
    species ="Human" ,
    gender = "Male",
    id = 1,
    image ="https://rickandmortyapi.com/api/character/avatar/1.jpeg" ,
)

val rickAndMortyEntityList = mutableListOf(rickAndMortyEntity)