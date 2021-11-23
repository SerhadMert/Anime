package com.example.anime.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anime.data.model.song.Document
import com.example.anime.databinding.ItemSongListBinding

class AnimeSongAdapter: RecyclerView.Adapter<AnimeSongAdapter.AnimeSongViewHolder>() {

    private var list = emptyList<Document>()
    private var listener: AnimeOnClickListener? = null
    private var selectedItem = 0

    inner class AnimeSongViewHolder(private val binding: ItemSongListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
        fun bind(document: Document) {
            binding.apply {
                textTitle.text = "${document.title} -"
                textArtist.text = document.artist
                crdItem.setOnClickListener {
                    selectedItem = adapterPosition
                    listener?.onClick(document)
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeSongViewHolder {
        val view = LayoutInflater.from(parent.context)
        return AnimeSongViewHolder(ItemSongListBinding.inflate(view, parent, false))
    }

    override fun onBindViewHolder(holder: AnimeSongViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<Document>) {
        list = newList
        notifyDataSetChanged()
    }

    fun addListener(listener: AnimeOnClickListener) {
        this.listener = listener
    }

    fun removeListener() {
        this.listener = null
    }
}