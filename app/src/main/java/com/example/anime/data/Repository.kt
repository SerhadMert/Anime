package com.example.anime.data

import com.example.anime.data.remote.ApiDataSource
import com.example.anime.utils.performNetworkOperation
import javax.inject.Inject

class Repository
@Inject constructor(private var apiDataSource: ApiDataSource){

    fun getALLAnimesByName(title: String,page: Int) = performNetworkOperation {
        apiDataSource.getALLAnimesByName(title,page)
    }

    fun getAnimeById(id : Int) = performNetworkOperation {
        apiDataSource.getAnimeById(id)
    }

    fun getAllEpisodeById(id: Int,source: String,locale: String,number: Int?) = performNetworkOperation {
        apiDataSource.getAllEpisodeById(id,source,locale,number)
    }

    fun getAllSongsById(id: Int,title: String) = performNetworkOperation {
        apiDataSource.getAllSongsById(id,title)
    }
}