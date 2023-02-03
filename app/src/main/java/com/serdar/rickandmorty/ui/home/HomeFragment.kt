package com.serdar.rickandmorty.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.serdar.rickandmorty.R
import com.serdar.rickandmorty.databinding.FragmentHomeBinding
import com.serdar.rickandmorty.utility.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel by viewModels<HomeViewModel>()
    private  val adapter by lazy { HomeAdapter(::itemSetClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeSearchViewTextChanges()
        viewState()
        viewModel.getRickAndMorty()
    }

    private fun observeSearchViewTextChanges() {
        binding.searchEditText.observeTextChanges()
            .filter { it okWith MINIMUM_SEARCH_LENGTH }
            .debounce(SEARCH_DEBOUNCE_TIME_IN_MILLISECONDS)
            .distinctUntilChanged()
            .onEach {
                if(it.isBlank()){
                    viewModel.getRickAndMorty()
                }else{
                    viewModel.getRickAndMortyCharacter(it)
                }

            }.launchIn(lifecycleScope)
    }

    private fun viewState() {
        viewModel.rickAndMortyHomeUiState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeUiState.Loading -> {
                    //do something
                    binding.loading.loading()
                    println("data Loading")
                }
                is HomeUiState.Error -> {
                    //do something
                    println("data error")
                }
                is HomeUiState.Success -> {
                    //  viewModel.getRickAndMorty()
                    binding.loading.done()
                    handleUiState(it.data)
                    binding.allCharacter.adapter = adapter
                }
            }
        }


    }
    fun handleUiState(data: List<HomeUiData>){
        adapter.updateItems(data)
    }
    private fun itemSetClick(i: Int) {
       // Toast.makeText(requireContext(),"id $i",Toast.LENGTH_SHORT).show()
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(i)
        findNavController().navigate(action)

    }



    companion object {
        private const val MINIMUM_SEARCH_LENGTH = 1
        private const val SEARCH_DEBOUNCE_TIME_IN_MILLISECONDS = 300L

    }
}



