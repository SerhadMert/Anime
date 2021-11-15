package com.example.anime.data.remote

import com.example.anime.data.model.anime.Anime
import com.example.anime.data.model.detail.AnimeDetail
import com.example.anime.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.ALL_ANIMES_END_POINT)
    suspend fun getAnimeByName(
        @Query("title") title: String
    ): Response<Anime>

    @GET(Constants.SPECIFIC_ANIME_END_POINT)
    suspend fun getAnimeById(
        @Path("id") id: Int
    ): Response<AnimeDetail>
}