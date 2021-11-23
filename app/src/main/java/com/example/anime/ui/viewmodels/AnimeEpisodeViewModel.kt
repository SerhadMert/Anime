package com.example.anime.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anime.data.Repository
import com.example.anime.data.model.episode.Episode
import com.example.anime.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeEpisodeViewModel
@Inject constructor(private var repository: Repository) : ViewModel(){

    fun getAllEpisodeById(id: Int,source: String,locale: String,number: Int?): LiveData<Resource<Episode>>{
        return repository.getAllEpisodeById(id,source,locale,number)
    }
}