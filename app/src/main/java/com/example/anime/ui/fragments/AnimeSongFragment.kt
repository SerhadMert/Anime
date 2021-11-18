package com.example.anime.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.anime.base.BaseFragment
import com.example.anime.databinding.FragmentAnimeSongBinding
import com.example.anime.ui.adapters.AnimeSongAdapter
import com.example.anime.ui.viewmodels.AnimeSongViewModel
import com.example.anime.utils.Resource
import com.example.anime.utils.gone
import com.example.anime.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeSongFragment(id: Int) : BaseFragment<FragmentAnimeSongBinding>(FragmentAnimeSongBinding::inflate) {

    private val currentId=id
    private val viewModel by viewModels<AnimeSongViewModel>()
    private val adapter by lazy { AnimeSongAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllSongs()
    }

    private fun getAllSongs(){
        viewModel.getAllSongsById(currentId).observe(viewLifecycleOwner,{response ->
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
}