package com.example.socialfilmapp.domain.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    var id:Int,

    @SerializedName("first_name")
    var firstName:String,

    @SerializedName("last_name")
    var lastName:String,

    @SerializedName("email")
    var email:String,

    @SerializedName("password")
    var password:String,

) {
}