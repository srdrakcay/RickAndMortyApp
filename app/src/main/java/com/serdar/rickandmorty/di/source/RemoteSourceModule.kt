package com.serdar.rickandmorty.di.source


import com.serdar.rickandmorty.data.source.RemoteDataSource
import com.serdar.rickandmorty.data.source.RemoteDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteSourceModule {


    @Binds
    @ViewModelScoped
    abstract fun bindRickAndMortyRemoteSource(remoteDataSourceImp: RemoteDataSourceImp): RemoteDataSource
}