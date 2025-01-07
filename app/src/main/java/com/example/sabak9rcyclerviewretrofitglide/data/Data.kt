package com.example.sabak9rcyclerviewretrofitglide.data

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("memes")
    val memes: List<Meme>
)