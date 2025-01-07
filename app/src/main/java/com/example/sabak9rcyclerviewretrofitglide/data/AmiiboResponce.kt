package com.example.sabak9rcyclerviewretrofitglide.data

import com.google.gson.annotations.SerializedName

data class AmiiboResponce(
    @SerializedName("amiibo")
    val amiibo: List<Amiibo>
)