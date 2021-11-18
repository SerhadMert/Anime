package com.example.anime.data.model.episode


import com.google.gson.annotations.SerializedName

data class Document(
    @SerializedName("anime_id")
    val animeİd: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("locale")
    val locale: String?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("video")
    val video: String?
)