package com.example.socialfilmapp.domain.model

import com.google.gson.annotations.SerializedName

data class Film(
    @SerializedName("id")
    var id:Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("synopsis")
    var synopsis: String,
    @SerializedName("videoUrl")
    var video: String,
    @SerializedName("category")
    var category: Category,
    @SerializedName("bannerVideo")
    var bannerVideo: BannerVideo,
    @SerializedName("User")
    var user: User
) {
}