package com.example.socialfilmapp.domain.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,

    var listFilms:List<Film>



) {
}