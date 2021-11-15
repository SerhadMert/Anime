package com.example.anime.ui.fragments

import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.anime.base.BaseFragment
import com.example.anime.databinding.FragmentAnimeDetailBinding
import com.example.anime.ui.viewmodels.AnimeDetailViewModel
import com.example.anime.utils.Resource
import com.example.anime.utils.gone
import com.example.anime.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : BaseFragment<FragmentAnimeDetailBinding>(FragmentAnimeDetailBinding::inflate) {

    private val viewModel by viewModels<AnimeDetailViewModel>()
    private val args: AnimeDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAnimeDetails()
    }

    private fun getAnimeDetails() {
        viewModel.getAnimeById(args.animeId).observe(viewLifecycleOwner, { response ->
            when (response.status) {
                Resource.Status.LOADING -> {
                    binding.progressBar.show()
                }
                Resource.Status.SUCCESS -> {
                    binding.progressBar.gone()
                    response.data?.data?.let {
                        binding.apply {
                            Glide.with(requireContext())
                                .load(it.coverİmage)
                                .into(imgPhoto)
                            txtName.text = it.titles?.en.toString()
                            txtScore.text = it.score.toString()
                            txtDescription.text = Html.fromHtml(it.descriptions?.en)
                            imgBack.setOnClickListener {
                                findNavController().popBackStack()
                            }
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(requireContext(), "Error! Try again", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}