package com.example.socialfilmapp.domain

import com.example.socialfilmapp.domain.model.Category
import com.example.socialfilmapp.domain.model.Film
import com.example.socialfilmapp.domain.request.LoginRequest
import com.example.socialfilmapp.domain.request.RegisterRequest
import com.example.socialfilmapp.domain.responses.LoginResponse
import com.example.socialfilmapp.domain.responses.RegisterResponse
import com.example.socialfilmapp.utils.Constants
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST(Constants.LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST(Constants.SIGNUP_URL)
    fun register(@Body request: RegisterRequest):Call<RegisterResponse>

    @GET(Constants.FILMS_URL)
    fun getFilms():Response<List<Film>>

    @GET("categories/{id}/films")
    fun getFilmsbyCategory(@Path("id")id:Int):Call<List<Film>>

    @GET(Constants.CATEGORIES_URL)
    suspend fun getCategories():Response<List<Category>>
}