package com.serdar.rickandmorty.data.api

import com.google.common.truth.Truth.assertThat
import com.serdar.rickandmorty.data.constant.*
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RickAndMortyApiTest {
    private lateinit var api:RickAndMortyApi
    private val mockWebServer=MockWebServer()

    @Before
    fun setup(){
        mockWebServer.start(8080)
        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyApi::class.java)
    }

    @Test
    fun `when user requested for get all RickAndMorty Characters`(){
        runBlocking {
            enqueue()
            val response = api.getRickAndMorty()
            val request = mockWebServer.takeRequest()
            assertThat(response).isNotNull()
        }

    }

    @Test
    fun `when the first item id equal to first  RickAndMorty Character id`(){
        runBlocking {
            enqueue()
            val response = api.getRickAndMorty()
            val request = mockWebServer.takeRequest()
            val item=response.results[0].id
            assertThat(item).isEqualTo(1)
        }
    }
    @Test
    fun `when the RickAndMorty Character name equal to name`(){
        runBlocking {
            enqueue()
            val response = api.getRickAndMorty()
            val request = mockWebServer.takeRequest()
            val item=response.results[0].name
            assertThat(item).isEqualTo(CHARACTER_NAME)
        }

    }
    @Test
    fun `when the RickAndMorty Character type is empty`(){
        runBlocking {
            enqueue()
            val response = api.getRickAndMorty()
            val request = mockWebServer.takeRequest()
            val item=response.results[0].type
            assertThat(item).isEmpty()
        }
    }
    @Test
    fun `when the Rick And Morty all character request path equal to getRickAndMorty`(){
        runBlocking {
            enqueue()
            val response = api.getRickAndMorty()
            val request = mockWebServer.takeRequest()
            assertThat(request.path).isEqualTo(ALL_CHARACTER_PATH)
        }
    }
    @Test
    fun  `when the Rick And Morty all character request path equal to getRickAndMortyCharacter`(){
        runBlocking {
            enqueue()
            val response = api.getRickAndMortyCharacter(CHARACTER_NUMBER)
            val request = mockWebServer.takeRequest()
            assertThat(request.path).isEqualTo(CHARACTER_PATH)
        }
         }

    private fun enqueue(fileName: String = SAMPLE_RESPONSE_FILE_NAME) {
        javaClass.classLoader?.let {
            val inputStream = it.getResourceAsStream(fileName)
            val source = inputStream.source().buffer()
            val mockResponse = MockResponse()
            mockResponse.setBody(source.readString(Charsets.UTF_8))
            mockWebServer.enqueue(mockResponse)
        }
    }
    @After
    fun shotDown(){
        mockWebServer.shutdown()
    }
}