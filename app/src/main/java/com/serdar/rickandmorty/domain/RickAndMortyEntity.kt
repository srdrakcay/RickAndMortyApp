package com.serdar.rickandmorty.domain

import com.google.gson.annotations.SerializedName

data class RickAndMortyEntity(
    @SerializedName("species")
    val species: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: Int,

)
