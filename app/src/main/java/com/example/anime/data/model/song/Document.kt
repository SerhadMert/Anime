package com.example.anime.data.model.song


import com.google.gson.annotations.SerializedName

data class Document(
    @SerializedName("album")
    val album: String?,
    @SerializedName("anime_id")
    val animeİd: Int?,
    @SerializedName("artist")
    val artist: String?,
    @SerializedName("duration")
    val duration: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("local_spotify_url")
    val localSpotifyUrl: String?,
    @SerializedName("open_spotify_url")
    val openSpotifyUrl: String?,
    @SerializedName("preview_url")
    val previewUrl: String?,
    @SerializedName("season")
    val season: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: Int?,
    @SerializedName("year")
    val year: Int?
)