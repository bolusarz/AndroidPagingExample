package com.bolusarz.androidpagination.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bolusarz.androidpagination.databinding.BeerLayoutBinding
import com.bolusarz.androidpagination.load
import com.bolusarz.androidpagination.model.Beer

class BeerViewHolder(private val itemBinding: BeerLayoutBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(beer: Beer) {
        itemBinding.beer = beer
        itemBinding.beerImageIv.load(beer.imageUrl)
        itemBinding.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup): BeerViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = BeerLayoutBinding.inflate(inflater, parent, false)
            return BeerViewHolder(binding)
        }
    }
}