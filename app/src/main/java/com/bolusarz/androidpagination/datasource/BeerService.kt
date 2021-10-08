package com.bolusarz.androidpagination.datasource

import com.bolusarz.androidpagination.model.Beer
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerService {

    @GET("v2/beers")
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int = 5
    ): ArrayList<Beer>

}