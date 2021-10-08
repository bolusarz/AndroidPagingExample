package com.bolusarz.androidpagination

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import com.bolusarz.androidpagination.adapter.BeerPagerAdapter
import com.bolusarz.androidpagination.model.Beer
import com.bolusarz.androidpagination.viewmodel.BeerViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<BeerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = BeerPagerAdapter()

        recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.flow.collectLatest { value: PagingData<Beer> ->
                adapter.submitData(value)
            }
        }
    }
}