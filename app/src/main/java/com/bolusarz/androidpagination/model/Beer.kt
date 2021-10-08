package com.bolusarz.androidpagination.model

import com.google.gson.annotations.SerializedName

data class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    @SerializedName("description")
    val desc: String,
    @SerializedName("image_url")
    val imageUrl: String
)