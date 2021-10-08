package com.bolusarz.androidpagination.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bolusarz.androidpagination.databinding.BeerLayoutBinding
import com.bolusarz.androidpagination.model.Beer
import com.bumptech.glide.Glide

class BeerViewHolder(private val itemBinding: BeerLayoutBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(beer: Beer, context: Context) {
        itemBinding.beer = beer
        Glide.with(context).load(beer.imageUrl).into(itemBinding.beerImageIv)
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