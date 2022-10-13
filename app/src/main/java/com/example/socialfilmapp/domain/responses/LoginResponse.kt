package com.example.socialfilmapp.domain.responses

import com.example.socialfilmapp.domain.model.User
import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("status_code")
    var statusCode: Int,

    @SerializedName("auth_token")
    var token: String,

    @SerializedName("user")
    var user: User,

        ){
}