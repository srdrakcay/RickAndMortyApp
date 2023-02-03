package com.serdar.rickandmorty.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T :Any>(view:View):RecyclerView.ViewHolder(view){
    abstract fun onBind(data:T)
}