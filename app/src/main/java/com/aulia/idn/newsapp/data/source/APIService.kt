package com.aulia.idn.newsapp.data.source

import com.aulia.idn.newsapp.data.model.ResponseNews
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("top-headlines")
    suspend fun fetchNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apikey: String
    ): ResponseNews
}