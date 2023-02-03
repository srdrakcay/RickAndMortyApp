package com.serdar.rickandmorty.data.source

import com.google.common.truth.ExpectFailure.assertThat
import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.data.api.RickAndMortyApi
import com.serdar.rickandmorty.data.constant.characterResponseList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.lang.AssertionError

class RemoteDataSourceImplTest {
    @Mock
    private lateinit var api:RickAndMortyApi
    private lateinit var remoteDataSourceImp: RemoteDataSourceImp


    @Before
    fun setup (){
        MockitoAnnotations.openMocks(this)
        remoteDataSourceImp= RemoteDataSourceImp(api)
    }

    @Test
    fun `when character list returned is state success`() {
        runBlocking {
            Mockito.`when`(api.getRickAndMortyCharacter(characterNumber = "1"))
                .thenReturn(
                   characterResponseList[0]
                )
            val response = remoteDataSourceImp.getRickAndMortyCharacter("1")
            assertThat(AssertionError(response)).isInstanceOf(NetworkResponse.Success::class.java)
        }
}
    @Test
    fun `when character item list returned is state error`() {
        runBlocking {
            Mockito.`when`(api.getRickAndMortyCharacter("1"))
                .thenReturn(
                    null
                )
            val response = remoteDataSourceImp.getRickAndMortyCharacter("1")
            assertThat(AssertionError(response)).isInstanceOf(NetworkResponse.Error::class.java)
        }
    }


}