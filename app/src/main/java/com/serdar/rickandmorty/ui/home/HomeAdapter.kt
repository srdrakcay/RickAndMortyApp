package com.serdar.rickandmorty.ui.home

import android.view.ViewGroup
import com.serdar.rickandmorty.ui.base.BaseRecyclerViewAdapter


    class HomeAdapter(private val itemClickListener: ( (Int)-> Unit) ?): BaseRecyclerViewAdapter<HomeUiData,RickAndMortyViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyViewHolder {
            return RickAndMortyViewHolder.createFrom(parent,itemClickListener)
        }

    }