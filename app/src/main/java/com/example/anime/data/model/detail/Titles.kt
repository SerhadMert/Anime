package com.example.anime.data.model.detail


import com.google.gson.annotations.SerializedName

data class Titles(
    @SerializedName("en")
    val en: String?,
    @SerializedName("jp")
    val jp: String?
)