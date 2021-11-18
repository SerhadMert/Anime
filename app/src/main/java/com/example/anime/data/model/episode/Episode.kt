package com.example.anime.data.model.episode


import com.google.gson.annotations.SerializedName

data class Episode(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("version")
    val version: String?
)