package com.serdar.rickandmorty.domain.usecase.allcahracter

import com.serdar.rickandmorty.data.repository.RickAndMortyFakeRepository
import com.serdar.rickandmorty.domain.mapper.allcharacter.RickAndMortyDomainListMapperImp
import com.serdar.rickandmorty.domain.usecase.getallcharacter.GetRickAndMortyCharacterUseCaseImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.serdar.rickandmorty.data.NetworkResponse


class GetRickAndMortyCharacterUseCaseTest {

    private val rickAndMortyFakeRepository = RickAndMortyFakeRepository()

    private val rickAndMortyDomainListMapper = RickAndMortyDomainListMapperImp()

    private lateinit var getRickAndMortyCharacterUseCaseImpl: GetRickAndMortyCharacterUseCaseImpl

    @Before
    fun setup() {

        getRickAndMortyCharacterUseCaseImpl = GetRickAndMortyCharacterUseCaseImpl(
            rickAndMortyFakeRepository,
            rickAndMortyDomainListMapper
        )
    }

    @Test
    fun  `when the all character is the first stage dowlanding`(){
        runBlocking {
            getRickAndMortyCharacterUseCaseImpl().test{
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }
        }

    }
    @Test
    fun `when repositoryResponseFailure is state downloading and failure sequentially`() {
        rickAndMortyFakeRepository.updateShowError(true)
        runBlocking {
            getRickAndMortyCharacterUseCaseImpl().test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
                awaitComplete()
            }
        }
    }
    @Test
    fun `when repositoryResponseFailure is state downloading and success sequentially`(){
        runBlocking {
            getRickAndMortyCharacterUseCaseImpl().test {
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
                awaitComplete()
            }
        }
    }
}