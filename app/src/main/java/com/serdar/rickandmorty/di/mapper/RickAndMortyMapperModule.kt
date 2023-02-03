package com.serdar.rickandmorty.di.mapper

import com.serdar.rickandmorty.data.dto.allcharacter.Result
import com.serdar.rickandmorty.data.dto.character.CharacterResponse
import com.serdar.rickandmorty.domain.RickAndMortyEntity
import com.serdar.rickandmorty.domain.mapper.allcharacter.RickAndMortyDomainListMapperImp
import com.serdar.rickandmorty.domain.mapper.allcharacter.RickAndMortyListMapper
import com.serdar.rickandmorty.domain.mapper.character.CharacterDomainListMapper
import com.serdar.rickandmorty.ui.detail.DetailUiData
import com.serdar.rickandmorty.ui.detail.RickAndMortyDetailMapper
import com.serdar.rickandmorty.ui.home.HomeUiData
import com.serdar.rickandmorty.ui.home.RickAndMortyUiMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)

abstract class RickAndMortyMapperModule {

    @Binds
    @ViewModelScoped
    abstract fun rickAndMortyMapper(rickAndMortyDomainListMapperImp: RickAndMortyDomainListMapperImp): RickAndMortyListMapper<Result, RickAndMortyEntity>


    @Binds
    @ViewModelScoped
    abstract fun rickAndMortyUiMapper(rickAndMortyUiMapperImpl: RickAndMortyUiMapperImpl): RickAndMortyListMapper<RickAndMortyEntity, HomeUiData>


    @Binds
    @ViewModelScoped
    abstract fun rickAndMortyCharacterMapper(characterDomainListMapper: CharacterDomainListMapper): RickAndMortyListMapper<CharacterResponse, RickAndMortyEntity>

    @Binds
    @ViewModelScoped
    abstract fun rickAndMortyDetailUiMapper(rickAndMortyDetailUiMapper: RickAndMortyDetailMapper): RickAndMortyListMapper<RickAndMortyEntity, DetailUiData>

}


