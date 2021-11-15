package com.example.anime.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.anime.data.Repository
import com.example.anime.data.model.detail.AnimeDetail
import com.example.anime.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel
@Inject constructor(private var repository: Repository): ViewModel(){

    fun getAnimeById(id: Int): LiveData<Resource<AnimeDetail>>{
       return repository.getAnimeById(id)
    }
}