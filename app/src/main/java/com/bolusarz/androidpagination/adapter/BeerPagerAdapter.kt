package com.bolusarz.androidpagination.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.bolusarz.androidpagination.model.Beer
import com.bolusarz.androidpagination.viewholder.BeerViewHolder

class BeerPagerAdapter : PagingDataAdapter<Beer, BeerViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val beer = getItem(position)
        if (beer != null) {
            holder.bind(beer)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder =
        BeerViewHolder.create(parent)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Beer>() {
            override fun areItemsTheSame(oldItem: Beer, newItem: Beer): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Beer, newItem: Beer): Boolean {
                return oldItem == newItem
            }

        }
    }

}