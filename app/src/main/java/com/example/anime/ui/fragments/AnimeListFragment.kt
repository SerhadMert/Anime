package com.example.anime.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import com.example.anime.base.BaseFragment
import com.example.anime.databinding.FragmentAnimeListBinding
import com.example.anime.ui.adapters.AnimeListAdapter
import com.example.anime.ui.viewmodels.AnimeListViewModel
import com.example.anime.utils.Resource
import com.example.anime.utils.gone
import com.example.anime.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeListFragment : BaseFragment<FragmentAnimeListBinding>(FragmentAnimeListBinding::inflate) {
    private val viewModel by viewModels<AnimeListViewModel>()
    private val adapter by lazy { AnimeListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAnimeByName()
        searchViewListener()
    }

    private fun getAnimeByName(title: String="") {
        viewModel.getAnimeByName(title).observe(viewLifecycleOwner, { response ->
            when (response.status) {
                Resource.Status.LOADING -> {
                    binding.progressBar.show()
                }
                Resource.Status.SUCCESS -> {
                    binding.progressBar.gone()
                    if(response.data?.data?.documents?.size != 0)
                        response.data?.data?.let { adapter.setData(it.documents) }
                    binding.rvAnimeList.adapter=adapter
                }
                Resource.Status.ERROR -> {
                    Log.v("animes", "Error")
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
                getAnimeByName(newText)
                }
                return true
            }

        })
    }
}