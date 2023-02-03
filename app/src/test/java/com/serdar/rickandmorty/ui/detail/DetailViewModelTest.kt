package com.serdar.rickandmorty.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.serdar.rickandmorty.data.NetworkResponse
import com.serdar.rickandmorty.domain.constant.rickAndMortyEntityList
import com.serdar.rickandmorty.domain.usecase.getallcharacter.GetRickAndMortyCharacterUseCaseImpl
import com.serdar.rickandmorty.domain.usecase.getcharacter.GetRickAndMortyUseCaseImp
import com.serdar.rickandmorty.ui.constant.detailUiDataList
import com.serdar.rickandmorty.ui.constant.homeUiDataList
import com.serdar.rickandmorty.ui.home.HomeUiState
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

class DetailViewModelTest {


    @Mock
    private lateinit var getRickAndMortyUseCase: GetRickAndMortyUseCaseImp

    private val rickAndMortyDetailMapper = RickAndMortyDetailMapper()

    private lateinit var viewModel: DetailViewModel

    @Mock
    private lateinit var observer: Observer<DetailUiState>

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = DetailViewModel(
            getRickAndMortyUseCase,
            rickAndMortyDetailMapper
        )
        viewModel.rickAndMortyDetailUiState.observeForever(observer)
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
            verify(observer).onChanged(DetailUiState.Loading)
            verify(observer).onChanged(DetailUiState.Success(detailUiDataList))
        }
    }


    @After
    fun shutdown() {
        Dispatchers.resetMain()
        viewModel.rickAndMortyDetailUiState.removeObserver(observer)
    }
}
