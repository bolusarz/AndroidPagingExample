package com.bolusarz.androidpagination.datasource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bolusarz.androidpagination.model.Beer
import javax.inject.Inject


class BeerPagedDataSource @Inject constructor(
    private val beerService: BeerService
) : PagingSource<Int, Beer>() {

    override fun getRefreshKey(state: PagingState<Int, Beer>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Beer> {
        val nextPageNum = params.key ?: 1
        val itemsPerPage = params.loadSize
        val beers = beerService.getBeers(nextPageNum, itemsPerPage)
        return try {
            LoadResult.Page(
                data = beers,
                prevKey = null,
                nextKey = nextPageNum + 1
            )
        } catch (ex: Exception) {
            Log.e(TAG, ex.message.toString())
            LoadResult.Page(
                data = listOf(),
                prevKey = null,
                nextKey = null
            )
        }
    }

    companion object {
        const val TAG = "BeerPagedDataSource"
    }
}