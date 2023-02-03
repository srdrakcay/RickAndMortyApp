package com.serdar.rickandmorty.di.repository

import com.serdar.rickandmorty.data.repository.RickAndMortyRepository
import com.serdar.rickandmorty.data.repository.RickAndMortyRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RickAndMortyRepositoryModule {


    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyRepository(repositoryImp: RickAndMortyRepositoryImp): RickAndMortyRepository
}