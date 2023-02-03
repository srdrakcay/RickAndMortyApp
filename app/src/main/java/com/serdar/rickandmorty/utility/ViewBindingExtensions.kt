package com.serdar.rickandmorty.utility

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

inline fun <T: ViewBinding> ViewGroup.inflateAdapterItem(
    crossinline bindingInflater:(LayoutInflater, ViewGroup? ,Boolean)-> T)=bindingInflater(LayoutInflater.from(this.context),this,false)
