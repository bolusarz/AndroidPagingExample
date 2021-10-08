package com.bolusarz.androidpagination.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.bolusarz.androidpagination.datasource.BeerPagedDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BeerViewModel @Inject constructor(
    dataSource: BeerPagedDataSource
) : ViewModel() {

    val flow = Pager(PagingConfig(pageSize = 10)) { dataSource }.flow.cachedIn(viewModelScope)

}