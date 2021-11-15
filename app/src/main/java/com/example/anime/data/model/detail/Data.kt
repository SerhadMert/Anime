package com.example.anime.data.model.detail


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("anilist_id")
    val anilistİd: Int?,
    @SerializedName("banner_image")
    val bannerİmage: String?,
    @SerializedName("cover_color")
    val coverColor: String?,
    @SerializedName("cover_image")
    val coverİmage: String?,
    @SerializedName("descriptions")
    val descriptions: Descriptions?,
    @SerializedName("end_date")
    val endDate: String?,
    @SerializedName("episode_duration")
    val episodeDuration: Int?,
    @SerializedName("episodes_count")
    val episodesCount: Int?,
    @SerializedName("format")
    val format: Int?,
    @SerializedName("genres")
    val genres: List<String>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("mal_id")
    val malİd: Int?,
    @SerializedName("score")
    val score: Int?,
    @SerializedName("season_period")
    val seasonPeriod: Int?,
    @SerializedName("season_year")
    val seasonYear: Int?,
    @SerializedName("start_date")
    val startDate: String?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("titles")
    val titles: Titles?,
    @SerializedName("trailer_url")
    val trailerUrl: String?
)