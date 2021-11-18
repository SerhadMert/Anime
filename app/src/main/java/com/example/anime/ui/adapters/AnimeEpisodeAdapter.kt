package com.example.anime.ui.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anime.data.model.episode.Data
import com.example.anime.data.model.episode.Document
import com.example.anime.data.model.episode.Episode
import com.example.anime.databinding.ItemEpisodeListBinding

class AnimeEpisodeAdapter : RecyclerView.Adapter<AnimeEpisodeAdapter.AnimeEpisodeViewHolder>() {
    private var list = emptyList<Document>()

    inner class AnimeEpisodeViewHolder(private val binding: ItemEpisodeListBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(episode: Document){
                binding.apply {
                    textTitle.text = episode.title
                    textNumber.text = episode.number.toString()
                    crdItem.setOnClickListener {
                        it.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(list[position].video)))
                    }
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeEpisodeViewHolder {
        val view = LayoutInflater.from(parent.context)
        return AnimeEpisodeViewHolder(ItemEpisodeListBinding.inflate(view,parent,false))
    }

    override fun onBindViewHolder(holder: AnimeEpisodeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<Document>){
        list = ArrayList(newList)
        notifyDataSetChanged()
    }

}