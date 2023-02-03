package com.serdar.rickandmorty.di.usecase

import com.serdar.rickandmorty.domain.usecase.getallcharacter.GetRickAndMortyCharacterUseCase
import com.serdar.rickandmorty.domain.usecase.getallcharacter.GetRickAndMortyCharacterUseCaseImpl
import com.serdar.rickandmorty.domain.usecase.getcharacter.GetRickAndMortyUseCase
import com.serdar.rickandmorty.domain.usecase.getcharacter.GetRickAndMortyUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)

abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetRickAndMortyUseCase(getRickAndMortyUseCaseImp: GetRickAndMortyUseCaseImp): GetRickAndMortyUseCase


    @Binds
    @ViewModelScoped
    abstract fun bindGetRickAndMortyCharacterUseCase(getRickAndMortyCharacterUseCaseImpl: GetRickAndMortyCharacterUseCaseImpl): GetRickAndMortyCharacterUseCase
}


