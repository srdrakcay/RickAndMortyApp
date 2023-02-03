package com.serdar.rickandmorty.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.domain.constant.rickAndMortyEntity
import com.serdar.rickandmorty.domain.constant.rickAndMortyEntityList
import com.serdar.rickandmorty.domain.usecase.getallcharacter.GetRickAndMortyCharacterUseCaseImpl
import com.serdar.rickandmorty.domain.usecase.getcharacter.GetRickAndMortyUseCase
import com.serdar.rickandmorty.domain.usecase.getcharacter.GetRickAndMortyUseCaseImp
import com.serdar.rickandmorty.ui.constant.homeUiDataList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify

class HomeViewModelTest {

    @Mock
    private lateinit var getRickAndMortyUseCase: GetRickAndMortyUseCaseImp

    @Mock
    private lateinit var getRickAndMortyCharacterUseCase: GetRickAndMortyCharacterUseCaseImpl

    private val rickAndMortyUiMapperImpl = RickAndMortyUiMapperImpl()

    private lateinit var viewModel: HomeViewModel

    @Mock
    private lateinit var observer: Observer<HomeUiState>

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = HomeViewModel(getRickAndMortyUseCase,getRickAndMortyCharacterUseCase,rickAndMortyUiMapperImpl)
        viewModel.rickAndMortyHomeUiState.observeForever(observer)
    }

    //mapper isnt correct thats qhy this test not working
    // image turning the type and this controlling isn't work that's why
    @Test
    fun when_characterUseCaseReturnedDownloading_is_live_data_state_downloading() {
        runBlocking {
            Mockito.`when`(getRickAndMortyUseCase.invoke("10"))
                .thenReturn(flow {
                    emit(NetworkResponse.Loading)
                    emit(NetworkResponse.Success(rickAndMortyEntityList))
                })

                viewModel.getRickAndMortyCharacter("10")
            verify(observer).onChanged(HomeUiState.Loading)
            verify(observer).onChanged(HomeUiState.Success(homeUiDataList))
        }
    }
    @Test
    fun when_UseCaseReturnedDownloading_is_live_data_state_downloading() {
        runBlocking {
            Mockito.`when`(getRickAndMortyCharacterUseCase.invoke())
                .thenReturn(flow {
                    emit(NetworkResponse.Loading)
                    emit(NetworkResponse.Success(rickAndMortyEntityList))
                })

            viewModel.getRickAndMorty()
            verify(observer).onChanged(HomeUiState.Loading)
            verify(observer).onChanged(HomeUiState.Success(homeUiDataList))
        }
    }

    @After
    fun shutdown() {
        Dispatchers.resetMain()
        viewModel.rickAndMortyHomeUiState.removeObserver(observer)
    }

}