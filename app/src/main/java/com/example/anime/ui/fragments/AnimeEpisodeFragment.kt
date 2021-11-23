package com.example.anime.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import com.example.anime.base.BaseFragment
import com.example.anime.databinding.FragmentAnimeEpisodeBinding
import com.example.anime.ui.adapters.AnimeEpisodeAdapter
import com.example.anime.ui.viewmodels.AnimeEpisodeViewModel
import com.example.anime.utils.Resource
import com.example.anime.utils.gone
import com.example.anime.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeEpisodeFragment(id: Int) : BaseFragment<FragmentAnimeEpisodeBinding>
    (FragmentAnimeEpisodeBinding::inflate) {

    private val currentId= id
    private val viewModel by viewModels<AnimeEpisodeViewModel>()
    private val adapter by lazy { AnimeEpisodeAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllEpisodes()
        searchViewListener()
    }

    private fun getAllEpisodes(number: Int? = null) {
        viewModel.getAllEpisodeById(currentId,"dreamsub","it",number).observe(viewLifecycleOwner, { response ->
            when (response.status) {
                Resource.Status.LOADING -> {
                    binding.progressBar.show()
                }
                Resource.Status.SUCCESS -> {
                    binding.progressBar.gone()
                    if (response.data?.data?.documents?.size != 0)
                        response.data?.data?.let { adapter.setData(it.documents!!) }
                    binding.rvEpisodeList.adapter = adapter
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(requireContext(), "Error! Try again", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun searchViewListener(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(!newText.isNullOrEmpty()){
                    getAllEpisodes(newText.toInt())
                }else{
                    getAllEpisodes(null)
                }
                return true
            }

        })
    }
}