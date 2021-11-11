package com.example.anime.data.remote

import com.example.anime.data.model.Anime
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v1/anime")
    suspend fun getAnimeByName(
        @Query("title") title:String
    ): Response<Anime>
}