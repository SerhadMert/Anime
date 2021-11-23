package com.example.anime.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
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
        onScrollListener()
    }

    private fun getAnimeByName(title: String="") {
        viewModel.getALLAnimesByName(title,viewModel.page).observe(viewLifecycleOwner, { response ->
            when (response.status) {
                Resource.Status.LOADING -> {
                    binding.progressBar.show()
                }
                Resource.Status.SUCCESS -> {
                    binding.progressBar.gone()
                    if(response.data?.data?.documents?.size != 0){
                        response.data?.data?.let { adapter.setData(it.documents) }
                        viewModel.listSize = response.data?.data?.documents!!.size
                    binding.rvAnimeList.adapter=adapter
                    }
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(requireContext(), "Error! Try again", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun onScrollListener(){
        binding.rvAnimeList.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!binding.rvAnimeList.canScrollVertically(1) &&
                    newState == RecyclerView.SCROLL_STATE_IDLE
                ) {
                    if(viewModel.listSize == 100){
                        viewModel.pageIncrease()
                        getAnimeByName()
                    }
                }
                if(!binding.rvAnimeList.canScrollVertically(-1)&&
                        newState == RecyclerView.SCROLL_STATE_IDLE){
                    viewModel.pageDecrease()
                    getAnimeByName()
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
                    getAnimeByName(newText)
                } else {
                    getAnimeByName("")
                }
                return true
            }
        })
    }
}