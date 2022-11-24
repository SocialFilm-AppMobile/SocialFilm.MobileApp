package com.example.socialfilmapp.domain.model

import com.google.gson.annotations.SerializedName

data class SaveFilm(
    @SerializedName("title")
    val title: String,

    @SerializedName("synopsis")
    val synopsis: String,

    @SerializedName("videoUrl")
    val video: String,

    @SerializedName("categoryId")
    val categoryId: Int,

    @SerializedName("bannerVideo")
    val bannerVideo: BannerVideo,

    @SerializedName("userId")
    val userId: Int,
) {

}