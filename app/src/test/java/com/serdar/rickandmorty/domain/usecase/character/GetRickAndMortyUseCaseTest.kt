package com.serdar.rickandmorty.domain.usecase.character

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.data.repository.RickAndMortyFakeRepository
import com.serdar.rickandmorty.domain.mapper.character.CharacterDomainListMapper
import com.serdar.rickandmorty.domain.usecase.getcharacter.GetRickAndMortyUseCase
import com.serdar.rickandmorty.domain.usecase.getcharacter.GetRickAndMortyUseCaseImp
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetRickAndMortyUseCaseTest {

    private val rickAndMortyFakeRepository = RickAndMortyFakeRepository()

    private val characterDomainListMapper = CharacterDomainListMapper()

    private lateinit var getRickAndMortyUseCaseImpl: GetRickAndMortyUseCase

    @Before
    fun setup() {

        getRickAndMortyUseCaseImpl = GetRickAndMortyUseCaseImp(
            rickAndMortyFakeRepository,
            characterDomainListMapper
        )
    }
    @Test
    fun  `when the all character is the 10 first stage dowlanding`(){
        runBlocking {
            getRickAndMortyUseCaseImpl("10").test{
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }
        }

}
    @Test
    fun `when repositoryResponseFailure is state downloading and failure sequentially`() {
        rickAndMortyFakeRepository.updateShowError(true)
        runBlocking {
            getRickAndMortyUseCaseImpl("10").test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Error::class.java)
                awaitComplete()
            }
        }
    }
    @Test
    fun `when repositoryResponseFailure is state downloading and success sequentially`(){
        runBlocking {
            getRickAndMortyUseCaseImpl("10").test {
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Loading::class.java)
                Truth.assertThat(awaitItem()).isInstanceOf(NetworkResponse.Success::class.java)
                awaitComplete()
            }
        }
    }
}
