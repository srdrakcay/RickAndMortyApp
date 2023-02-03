package com.serdar.rickandmorty.di.coroutine

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
object CoroutineDispatchersModule {

    @IoDispatcher
    @Provides
    @ViewModelScoped
    fun providesIoDispatcher() = Dispatchers.IO
}