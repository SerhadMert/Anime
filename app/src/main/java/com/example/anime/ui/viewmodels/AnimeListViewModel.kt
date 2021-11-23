package com.example.anime.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime.data.Repository
import com.example.anime.data.model.anime.Anime
import com.example.anime.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeListViewModel
@Inject constructor(private var repository: Repository): ViewModel(){
    var page = 1
    var listSize = 0

    fun pageIncrease(){
        viewModelScope.launch {
            page = page.plus(1)
        }
    }

    fun pageDecrease(){
        viewModelScope.launch {
            if(page > 1)
            page = page.minus(1)
        }
    }

    fun getALLAnimesByName(title: String,page: Int): LiveData<Resource<Anime>>{
        return repository.getALLAnimesByName(title,page)
    }
}