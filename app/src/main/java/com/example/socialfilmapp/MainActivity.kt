package com.example.socialfilmapp

import PlaceHolderApi.PlaceHolderApi
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.socialfilmapp.adapter.Adapter
import com.example.socialfilmapp.databinding.ItemFilmBinding
import com.example.socialfilmapp.domain.model.Film
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), FilmsListener {

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
                recyclerView.layoutManager=GridLayoutManager(applicationContext,2)
                recyclerView.adapter= Adapter(listFilm, this@MainActivity)
            }
            override fun onFailure(call: Call<List<Film>>, t: Throwable) {
                println("error acaaaaaaaaaaaaa")
                t?.printStackTrace()
            }
        })
    }

    override fun onItemClick(film: Film) {
        val intent = Intent(this, ExtraInfoFilmActivity::class.java)
        intent.putExtra("FILM_TITLE",film.title)
        intent.putExtra("FILM_SYNOPSIS",film.synopsis)
        intent.putExtra("FILM_CATEGORY",film.category.name)
        intent.putExtra("FILM_IMAGE_BILLBOARD",film.bannerVideo.billboard)
        startActivity(intent)
    }
}