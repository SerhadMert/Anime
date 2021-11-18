package com.example.anime.data.remote

import com.example.anime.data.model.anime.Anime
import com.example.anime.data.model.detail.AnimeDetail
import com.example.anime.data.model.episode.Episode
import com.example.anime.data.model.song.Song
import com.example.anime.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.ALL_ANIMES_END_POINT)
    suspend fun getALLAnimesByName(
        @Query("title") title: String
    ): Response<Anime>

    @GET(Constants.SPECIFIC_ANIME_END_POINT)
    suspend fun getAnimeById(
        @Path("id") id: Int
    ): Response<AnimeDetail>

    @GET(Constants.ALL_EPISODES_END_POINT)
    suspend fun getALLEpisodesById(
        @Query("anime_id") id: Int,
        @Query("source") source: String,
        @Query("locale") locale: String
    ): Response<Episode>

    @GET(Constants.ALL_SONGS_END_POINT)
    suspend fun getAllSongsById(
        @Query("anime_id") id: Int
    ): Response<Song>
}