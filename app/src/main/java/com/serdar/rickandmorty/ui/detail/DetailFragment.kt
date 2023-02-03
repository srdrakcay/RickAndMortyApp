package com.serdar.rickandmorty.ui.detail


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.serdar.rickandmorty.R
import com.serdar.rickandmorty.databinding.FragmentDetailBinding
import com.serdar.rickandmorty.ui.home.HomeUiData
import com.serdar.rickandmorty.utility.loadUrl
import com.serdar.rickandmorty.utility.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val viewModel by viewModels<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewState()
    }

    private fun viewState() {

        viewModel.rickAndMortyDetailUiState.observe(viewLifecycleOwner) {
            when (it) {
                is DetailUiState.Loading -> {
                    //do something
                    // binding.loading.loading()
                    println("data Loading detail")
                }
                is DetailUiState.Error -> {
                    //do something
                    println("data error detail")
                }
                is DetailUiState.Success -> {
                    //
                    //
                    detailData(it.data)
                }
            }
        }

    }

    private fun initView() {
        val id = args.id.toString()
        viewState()
        viewModel.getRickAndMortyCharacter(id)
    }

    private fun detailData(data: List<DetailUiData>) {

        binding.name.text = data[0].name
        binding.characterImage.loadUrl(data[0].type)
        binding.gender.text = data[0].gender
        binding.species.text = data[0].species
        binding.type.text = data[0].image
    }
}