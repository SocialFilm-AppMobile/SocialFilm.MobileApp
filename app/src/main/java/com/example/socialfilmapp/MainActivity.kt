package com.example.socialfilmapp

import PlaceHolderApi.PlaceHolderApi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.socialfilmapp.adapter.Adapter
import com.example.socialfilmapp.domain.model.Film
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var service: PlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://socialfilm.azurewebsites.net/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create<PlaceHolderApi>(PlaceHolderApi::class.java)
        println("serviceeeeeeeeeeeeees $service")
        getAllFilms()
    }

    private fun getAllFilms() {
        service.getAllFilms().enqueue(object : Callback<List<Film>> {
            override fun onResponse(call: Call<List<Film>>, response: Response<List<Film>>) {
                val film = response?.body()
                println("film $film")
                val listFilm = mutableListOf<Film>()
                if (film != null) {
                    for (item in film) {
                        println("item $item")
                        listFilm.add(item)
                    }
                }
                val recyclerView= findViewById<RecyclerView>(R.id.recyclerViewFilms)
                recyclerView.layoutManager=LinearLayoutManager(applicationContext)
                recyclerView.adapter= Adapter(listFilm)
            }

            override fun onFailure(call: Call<List<Film>>, t: Throwable) {
                println("error acaaaaaaaaaaaaa")
                t?.printStackTrace()
            }
        })
    }
}