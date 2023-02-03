package com.serdar.rickandmorty.ui.home

import android.view.ViewGroup
import com.serdar.rickandmorty.databinding.RickAndMortyItemBinding
import com.serdar.rickandmorty.ui.base.BaseViewHolder
import com.serdar.rickandmorty.utility.inflateAdapterItem
class RickAndMortyViewHolder (private val binding: RickAndMortyItemBinding,
                              private val itemClick: ((Int)->Unit)?):
    BaseViewHolder<HomeUiData>(binding.root) {
    companion object{
        fun createFrom(parent: ViewGroup,itemClickListener: ((Int)->Unit)?)=
            RickAndMortyViewHolder(parent.inflateAdapterItem(RickAndMortyItemBinding::inflate),itemClickListener)
    }
    override fun onBind(data: HomeUiData) {
        binding.rickAndMortyComponent.setRickAndMortyCharacterData(data)
        binding.rickAndMortyComponent.setOnClickListener { itemClick?.invoke(data.id) }

    }
}