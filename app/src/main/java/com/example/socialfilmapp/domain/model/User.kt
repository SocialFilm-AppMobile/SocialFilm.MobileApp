package com.example.socialfilmapp.domain.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    var id:Int,

    @SerializedName("firstName")
    var firstName:String,

    @SerializedName("lastName")
    var lastName:String,

    @SerializedName("email")
    var email:String,


) {
}