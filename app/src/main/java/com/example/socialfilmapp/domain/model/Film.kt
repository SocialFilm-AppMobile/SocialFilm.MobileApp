package com.example.socialfilmapp.domain.model

data class Film(
    val title: String,
    val synopsis: String,
    val video: Video,
    val category: Category,
    val bannerVideo: BannerVideo
) {
}