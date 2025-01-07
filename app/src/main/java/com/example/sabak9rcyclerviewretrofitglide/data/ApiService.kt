package com.example.sabak9rcyclerviewretrofitglide.data

import retrofit2.http.GET

interface ApiService {
    @GET("get_memes")
    suspend fun getMeme():MemesResponce

    @GET("api/gameseries/")
    suspend fun getAmiibo():AmiiboResponce
}