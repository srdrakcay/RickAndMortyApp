package com.serdar.rickandmorty.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.serdar.rickandmorty.databinding.RickAndMortyComponentBinding
import com.serdar.rickandmorty.ui.home.HomeUiData
import com.serdar.rickandmorty.utility.loadUrl

class RickAndMortyUiComponent @JvmOverloads constructor(context:Context , attributeSet: AttributeSet ,defStyleAttr:Int=0):
    FrameLayout(context, attributeSet, defStyleAttr) {


   private val _binding= RickAndMortyComponentBinding.inflate(LayoutInflater.from(context),this,false)
init {

    addView(_binding.root)

}

    fun setRickAndMortyCharacterData(homeUiData: HomeUiData){
        _binding.characterName.text=homeUiData.name
        _binding.characterView.loadUrl(homeUiData.type)
        homeUiData.species?.let {
            _binding.characterType.text=it
           // println("geldi $it")
        }

    }
}