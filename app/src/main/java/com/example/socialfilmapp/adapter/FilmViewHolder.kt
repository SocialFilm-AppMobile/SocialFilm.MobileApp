package com.example.socialfilmapp.adapter

import android.content.DialogInterface
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.socialfilmapp.databinding.ItemFilmBinding
import com.example.socialfilmapp.domain.model.Film

class FilmViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val binding = ItemFilmBinding.bind(view)

    fun render(filmModel: Film){
        binding.tvTitleFilm.text = filmModel.title
        //Glide.with(binding.ivFilm.context).load(filmModel.bannerVideo.billboard).into(binding.ivFilm)
        //itemView.setOnClickListener{onClickListener(filmModel)}
    }
}