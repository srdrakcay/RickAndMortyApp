package com.serdar.rickandmorty.ui.base

import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.serdar.rickandmorty.R

abstract class BaseRecyclerViewAdapter <T :Any , VH:BaseViewHolder<T>>:RecyclerView.Adapter<VH>(){

    private val items = mutableListOf<T>()

    fun updateItems(newItems:List<T>) {
        items.apply {
            clear()
            addAll(newItems)
            notifyDataSetChanged()
        }
    }
    fun getItem(position:Int)=items[position]

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(items[position])
        println("gelmiş ${items[position]}")
        holder.itemView.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }
    }

    override fun getItemCount(): Int =items.size
}