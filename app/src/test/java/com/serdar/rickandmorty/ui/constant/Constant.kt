package com.serdar.rickandmorty.ui.constant

import com.serdar.rickandmorty.ui.detail.DetailUiData
import com.serdar.rickandmorty.ui.home.HomeUiData

val homeUiData =
 HomeUiData("","https://rickandmortyapi.com/api/character/avatar/1.jpeg",
     "Rick Sanchez",
 "Human",
 1,)

val homeUiDataList = mutableListOf(homeUiData)


val detailUiData =
    DetailUiData("","https://rickandmortyapi.com/api/character/avatar/1.jpeg",
        "Rick Sanchez",
        "Human",
        1, "Man")

val detailUiDataList = mutableListOf(detailUiData)


val apiException = Exception("Something went wrong")