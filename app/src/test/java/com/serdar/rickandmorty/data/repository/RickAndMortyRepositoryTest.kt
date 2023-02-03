package com.serdar.rickandmorty.data.repository


import com.serdar.rickandmorty.data.source.FakeRemoteDataSource
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

internal class RickAndMortyRepositoryTest {
    @Mock
    private lateinit var rickAndMortyRepositoryImp: RickAndMortyRepositoryImp
    private val fakeRemoteDataSource = FakeRemoteDataSource()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        rickAndMortyRepositoryImp = RickAndMortyRepositoryImp(fakeRemoteDataSource)

    }
}