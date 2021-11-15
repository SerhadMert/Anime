package com.example.anime.data.model.anime

data class Document(
    val anilist_id: Int?,
    val banner_image: String?,
    val cover_color: String?,
    val cover_image: String?,
    val descriptions: Descriptions?,
    val end_date: String?,
    val episode_duration: Int?,
    val episodes_count: Int?,
    val format: Int?,
    val genres: List<String>?,
    val id: Int?,
    val mal_id: Int?,
    val prequel: Int?,
    val score: Int?,
    val season_period: Int?,
    val season_year: Int?,
    val sequel: Int?,
    val start_date: String?,
    val status: Int?,
    val titles: Titles?,
    val trailer_url: String?
)