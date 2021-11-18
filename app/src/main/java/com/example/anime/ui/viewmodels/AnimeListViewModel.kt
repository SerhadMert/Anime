package com.example.anime.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.anime.data.Repository
import com.example.anime.data.model.anime.Anime
import com.example.anime.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeListViewModel
@Inject constructor(private var repository: Repository): ViewModel(){

    fun getALLAnimesByName(title: String): LiveData<Resource<Anime>>{
        return repository.getALLAnimesByName(title)
    }
}