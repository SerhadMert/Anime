package com.example.anime.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.anime.data.Repository
import com.example.anime.data.model.song.Song
import com.example.anime.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeSongViewModel
@Inject constructor(private var repository: Repository): ViewModel() {

    fun getAllSongsById(id: Int): LiveData<Resource<Song>>{
        return repository.getAllSongsById(id)
    }
}