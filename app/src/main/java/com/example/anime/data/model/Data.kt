package com.example.anime.data.model

data class Data(
    val count: Int,
    val current_page: Int,
    val documents: List<Document>,
    val last_page: Int
)