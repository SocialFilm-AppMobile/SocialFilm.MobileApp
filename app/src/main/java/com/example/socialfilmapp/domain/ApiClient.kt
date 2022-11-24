package com.example.socialfilmapp.domain

import android.content.Context
import okhttp3.OkHttpClient
import com.example.socialfilmapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private lateinit var apiService: ApiService
    private lateinit var apiService2: ApiService
    fun getApiService(context: Context):ApiService{

        if(!::apiService.isInitialized){
            val retrofit=Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient(context))
                .build()
            apiService=retrofit.create(ApiService::class.java)
        }
        return apiService
    }

    fun getApiServiceNI():ApiService{
        if(!::apiService.isInitialized){
            val retrofit=Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())


                .build()
            apiService=retrofit.create(ApiService::class.java)

        }
        return apiService
    }

    private fun okhttpClient(context: Context):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(context))
            .build()
    }
}