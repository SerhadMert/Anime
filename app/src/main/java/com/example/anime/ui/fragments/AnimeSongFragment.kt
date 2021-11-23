package com.example.anime.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.anime.base.BaseFragment
import com.example.anime.data.model.song.Document
import com.example.anime.databinding.FragmentAnimeSongBinding
import com.example.anime.ui.adapters.AnimeOnClickListener
import com.example.anime.ui.adapters.AnimeSongAdapter
import com.example.anime.ui.viewmodels.AnimeSongViewModel
import com.example.anime.utils.Resource
import com.example.anime.utils.gone
import com.example.anime.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeSongFragment(id: Int) : BaseFragment<FragmentAnimeSongBinding>(FragmentAnimeSongBinding::inflate) {

    private val currentId = id
    private val viewModel by viewModels<AnimeSongViewModel>()
    private val adapter by lazy { AnimeSongAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllSongs()
        searchViewListener()
        onClickListener()
    }

    private fun getAllSongs(title:String=""){
        viewModel.getAllSongsById(currentId,title).observe(viewLifecycleOwner,{response ->
            when(response.status){
                Resource.Status.LOADING -> {
                    binding.progressBar.show()
                }
                Resource.Status.SUCCESS -> {
                    binding.progressBar.gone()
                    if(response.data?.data?.documents?.size != 0)
                        response.data?.data?.let { adapter.setData(it.documents!!) }
                    binding.rvSongList.adapter=adapter

                }
                Resource.Status.ERROR -> {
                    Toast.makeText(requireContext(), "Error! Try again", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun searchViewListener() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrEmpty()) {
                    getAllSongs(newText)
                } else {
                    getAllSongs("")
                }
                return true
            }
        })
    }

    private fun onClickListener(){
        adapter.addListener(object : AnimeOnClickListener{
            override fun onClick(document: Document) {
                val action = AnimeTabControllerFragmentDirections
                    .actionAnimeTabControllerFragmentToAnimeSongSourceFragment(document.previewUrl!!,document.animeİd!!)
                findNavController().navigate(action)
                adapter.removeListener()
            }

        })
    }
}