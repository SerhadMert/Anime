package com.example.anime.data.remote

import com.example.anime.utils.BaseDataSource
import javax.inject.Inject

class ApiDataSource
@Inject constructor(private val apiService: ApiService): BaseDataSource(){
    suspend fun getALLAnimesByName(title: String,page: Int) = getResult {
        apiService.getALLAnimesByName(title,page)
    }

    suspend fun getAnimeById(id: Int) = getResult {
        apiService.getAnimeById(id)
    }

    suspend fun getAllEpisodeById(id: Int,source: String,locale: String,number: Int?) = getResult {
        apiService.getALLEpisodesById(id,source,locale,number)
    }

    suspend fun getAllSongsById(id: Int,title: String) = getResult {
        apiService.getAllSongsById(id,title)
    }
}