package com.example.anime.data

import com.example.anime.data.remote.ApiDataSource
import com.example.anime.utils.performNetworkOperation
import javax.inject.Inject

class Repository
@Inject constructor(private var apiDataSource: ApiDataSource){

    fun getALLAnimesByName(title: String) = performNetworkOperation {
        apiDataSource.getALLAnimesByName(title)
    }

    fun getAnimeById(id : Int) = performNetworkOperation {
        apiDataSource.getAnimeById(id)
    }

    fun getAllEpisodeById(id: Int,source: String,locale: String) = performNetworkOperation {
        apiDataSource.getAllEpisodeById(id,source,locale)
    }

    fun getAllSongsById(id: Int) = performNetworkOperation {
        apiDataSource.getAllSongsById(id)
    }
}