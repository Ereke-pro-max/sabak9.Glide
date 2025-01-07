package com.example.sabak9rcyclerviewretrofitglide.data

import com.google.gson.annotations.SerializedName

data class Amiibo(
    @SerializedName("key")
    val key: String,
    @SerializedName("name")
    val name: String
)