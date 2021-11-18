package com.example.anime.data.remote

import com.example.anime.utils.BaseDataSource
import javax.inject.Inject

class ApiDataSource
@Inject constructor(private val apiService: ApiService): BaseDataSource(){
    suspend fun getALLAnimesByName(title: String) = getResult {
        apiService.getALLAnimesByName(title)
    }

    suspend fun getAnimeById(id: Int) = getResult {
        apiService.getAnimeById(id)
    }

    suspend fun getAllEpisodeById(id: Int,source: String,locale: String) = getResult {
        apiService.getALLEpisodesById(id,source,locale)
    }

    suspend fun getAllSongsById(id: Int) = getResult {
        apiService.getAllSongsById(id)
    }
}