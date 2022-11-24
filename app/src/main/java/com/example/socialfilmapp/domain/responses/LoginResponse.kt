package com.example.socialfilmapp.domain.responses

import com.example.socialfilmapp.domain.model.User
import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("id")
    var id:Int,

    @SerializedName("firstName")
    var firstName:String,

    @SerializedName("lastName")
    var lastName:String,

    @SerializedName("email")
    var email:String,

    @SerializedName("token")
    var token: String,

        ){
}