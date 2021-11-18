package com.example.anime.data.model.song


import com.google.gson.annotations.SerializedName

data class Song(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("version")
    val version: String?
)