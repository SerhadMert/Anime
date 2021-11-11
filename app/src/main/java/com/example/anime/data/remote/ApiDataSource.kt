package com.example.anime.data.remote

import com.example.anime.utils.BaseDataSource
import javax.inject.Inject

class ApiDataSource
@Inject constructor(private val apiService: ApiService): BaseDataSource(){
    suspend fun getAnimeByName(title:String) = getResult {
        apiService.getAnimeByName(title)
    }
}