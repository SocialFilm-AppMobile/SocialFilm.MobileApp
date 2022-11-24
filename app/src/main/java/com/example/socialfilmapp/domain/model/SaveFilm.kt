package com.example.socialfilmapp.domain.model

import com.google.gson.annotations.SerializedName

data class SaveFilm(
    @SerializedName("title")
    var title: String,

    @SerializedName("synopsis")
    var synopsis: String,

    @SerializedName("videoUrl")
    var video: String,

    @SerializedName("categoryId")
    var categoryId: Int,

    @SerializedName("bannerVideo")
    var bannerVideo: BannerVideo,

    @SerializedName("userId")
    var userId: Int,
) {

}