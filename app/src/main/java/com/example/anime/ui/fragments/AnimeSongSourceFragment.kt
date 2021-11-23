package com.example.anime.ui.fragments

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.anime.base.BaseFragment
import com.example.anime.databinding.FragmentAnimeSongSourceBinding
import com.example.anime.utils.gone
import com.example.anime.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeSongSourceFragment : BaseFragment<FragmentAnimeSongSourceBinding>
    (FragmentAnimeSongSourceBinding::inflate) {

    private val args by navArgs<AnimeSongSourceFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBack()
        initViews()
    }

    private fun initBack(){
        binding.backButtonWebView.setOnClickListener {
            val action = AnimeSongSourceFragmentDirections
                .actionAnimeSongSourceFragmentToAnimeTabControllerFragment(args.id)
            it.findNavController().navigate(action)
        }
    }

    private fun initViews(){
        binding.songWebView.webViewClient = WebViewClient()
        args.spotifyUrl.let {
            binding.songWebView.loadUrl(it)
        }
    }

    inner class WebViewClient : android.webkit.WebViewClient() {
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            binding.progressBar.gone()
            binding.songWebView.show()
        }
    }
}