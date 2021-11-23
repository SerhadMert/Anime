package com.example.anime.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.anime.ui.fragments.AnimeDetailFragment
import com.example.anime.ui.fragments.AnimeEpisodeFragment
import com.example.anime.ui.fragments.AnimeSongFragment


class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):
FragmentStateAdapter(fragmentManager,lifecycle){

    private var currentArgId =0
    override fun getItemCount() = 3


    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> AnimeDetailFragment(currentArgId)
            1 -> AnimeEpisodeFragment(currentArgId)
            2 -> AnimeSongFragment(currentArgId)
            else -> Fragment()
        }
    }
    fun setArg(id: Int){
        currentArgId = id
    }
}