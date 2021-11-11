package com.example.anime.data

import com.example.anime.data.remote.ApiDataSource
import com.example.anime.utils.performNetworkOperation
import javax.inject.Inject

class Repository
@Inject constructor(private val apiDataSource: ApiDataSource){

    fun getAnimeByName(title: String) = performNetworkOperation {
        apiDataSource.getAnimeByName(title)
    }
}