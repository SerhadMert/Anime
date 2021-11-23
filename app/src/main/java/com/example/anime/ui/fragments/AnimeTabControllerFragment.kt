package com.example.anime.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.anime.base.BaseFragment
import com.example.anime.databinding.FragmentAnimeTabControllerBinding
import com.example.anime.ui.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeTabControllerFragment : BaseFragment<FragmentAnimeTabControllerBinding>
    (FragmentAnimeTabControllerBinding::inflate) {

    private val adapter by lazy { ViewPagerAdapter(childFragmentManager,lifecycle) }
    private val fragmentArray = arrayOf("Detail","Episode","Song")
    private val args: AnimeTabControllerFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabs()
        initBack()
    }

    private fun initTabs(){
        adapter.setArg(args.id)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = fragmentArray[position]
        }.attach()
    }

    private fun initBack(){
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}