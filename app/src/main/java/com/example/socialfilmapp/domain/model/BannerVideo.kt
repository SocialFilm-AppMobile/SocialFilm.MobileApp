package com.example.socialfilmapp.domain.model

import com.google.gson.annotations.SerializedName

data class BannerVideo(
    @SerializedName("billboard")
    var billboard: String,
    @SerializedName("banner")
    var Banner: String
) {
}