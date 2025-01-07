package com.example.sabak9rcyclerviewretrofitglide.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private const val BASE_URL_MEME = "https://api.imgflip.com/"
    private const val BASE_URL_AMIIBO = "https://www.amiiboapi.com/"


    private val retrofitMemes: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL_MEME).addConverterFactory(GsonConverterFactory.create())
            .build()
    private val retrofitAmiibo: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL_AMIIBO).addConverterFactory(GsonConverterFactory.create())
            .build()


    val apiService:ApiService = retrofitMemes.create(ApiService::class.java)
    val apiServiceAmiibo:ApiService = retrofitAmiibo.create(ApiService::class.java)
}