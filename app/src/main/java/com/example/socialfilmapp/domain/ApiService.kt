package com.example.socialfilmapp.domain

import com.example.socialfilmapp.domain.request.LoginRequest
import com.example.socialfilmapp.domain.responses.LoginResponse
import com.example.socialfilmapp.utils.Constants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded

import retrofit2.http.POST

interface ApiService {

    @POST(Constants.LOGIN_URL)

    fun login(@Body request: LoginRequest): Call<LoginResponse>
}