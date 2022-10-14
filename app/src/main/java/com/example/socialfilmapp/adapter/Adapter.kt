package com.example.socialfilmapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.socialfilmapp.FilmsListener
import com.example.socialfilmapp.R
import com.example.socialfilmapp.domain.model.Film
import retrofit2.Callback

class Adapter(val listFilms: List<Film>, val listener: FilmsListener): RecyclerView.Adapter<FilmViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return FilmViewHolder(layoutInflater.inflate(R.layout.item_film, parent, false))
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val item = listFilms[position]
        holder.render(item, listener)
    }

    override fun getItemCount(): Int {
        return listFilms.size
    }
}