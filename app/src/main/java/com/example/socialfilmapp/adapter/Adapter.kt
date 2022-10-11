package com.example.socialfilmapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.socialfilmapp.R
import com.example.socialfilmapp.domain.model.Film

class Adapter(val listFilms: List<Film>): RecyclerView.Adapter<FilmViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return FilmViewHolder(layoutInflater.inflate(R.layout.item_film, parent, false))
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val item = listFilms[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return listFilms.size
    }
}