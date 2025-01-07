package com.example.sabak9rcyclerviewretrofitglide.data

import com.google.gson.annotations.SerializedName

data class MemesResponce(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean
)