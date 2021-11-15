package com.example.anime.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.anime.data.model.anime.Document
import com.example.anime.databinding.ItemAnimeListBinding
import com.example.anime.ui.fragments.AnimeListFragmentDirections
import com.example.anime.utils.Constants

class AnimeListAdapter : RecyclerView.Adapter<AnimeListAdapter.AnimeListViewHolder>() {
    private var list : List<Document> = emptyList()

    inner class AnimeListViewHolder(private val binding: ItemAnimeListBinding):
        RecyclerView.ViewHolder(binding.root) {

            @SuppressLint("SetTextI18n")
            fun bind(anime: Document){
                binding.apply {
                    Glide.with(imageView.context).load(anime.cover_image).into(imageView)
                    textAnimeName.text = anime.titles?.en
                    textScore.text = anime.score.toString()
                    when(anime.status){
                        0 -> textStatus.text = Constants.FINISHED
                        1 -> textStatus.text = Constants.RELEASING
                        2 -> textStatus.text = Constants.NOT_YET_RELEASED
                        3 -> textStatus.text = Constants.CANCELLED
                    }
                    crdItem.setOnClickListener {
                        val action = AnimeListFragmentDirections.actionAnimeListFragmentToAnimeDetailFragment(anime.id!!)
                        it.findNavController().navigate(action)
                    }
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeListViewHolder {
        val view = LayoutInflater.from(parent.context)
        return AnimeListViewHolder(ItemAnimeListBinding.inflate(view,parent,false))
    }

    override fun onBindViewHolder(holder: AnimeListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<Document>){
        list = ArrayList(newList)
        notifyDataSetChanged()
    }
}