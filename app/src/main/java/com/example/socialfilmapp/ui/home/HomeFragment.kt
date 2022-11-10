package com.example.socialfilmapp.ui.home

import PlaceHolderApi.PlaceHolderApi
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.socialfilmapp.ExtraInfoFilmActivity
import com.example.socialfilmapp.FilmsListener
import com.example.socialfilmapp.R
import com.example.socialfilmapp.adapter.Adapter
import com.example.socialfilmapp.databinding.FragmentHomeBinding
import com.example.socialfilmapp.domain.model.Film
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() , FilmsListener {

    private var _binding: FragmentHomeBinding? = null

    lateinit var service: PlaceHolderApi

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://socialfilm.azurewebsites.net/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create<PlaceHolderApi>(PlaceHolderApi::class.java)
        println("serviceeeeeeeeeeeeees $service")

        getAllFilms()

        return root

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
                val recyclerView= _binding?.recyclerViewFilms
                if (recyclerView != null) {
                    recyclerView.layoutManager= GridLayoutManager(context, 2)
                }
                if (recyclerView != null) {
                    recyclerView.adapter= Adapter(listFilm, this@HomeFragment)
                }
            }
            override fun onFailure(call: Call<List<Film>>, t: Throwable) {
                println("error acaaaaaaaaaaaaa")
                t?.printStackTrace()
            }
        })
    }

    override fun onItemClick(film: Film) {
        val intent = Intent(context, ExtraInfoFilmActivity::class.java)
        intent.putExtra("FILM_TITLE",film.title)
        intent.putExtra("FILM_SYNOPSIS",film.synopsis)
        intent.putExtra("FILM_CATEGORY",film.category.name)
        intent.putExtra("FILM_IMAGE_BILLBOARD",film.bannerVideo.billboard)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}