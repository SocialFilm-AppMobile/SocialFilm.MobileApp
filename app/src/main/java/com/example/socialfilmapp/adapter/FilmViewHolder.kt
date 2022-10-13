package com.example.socialfilmapp.adapter

import android.content.DialogInterface
import android.view.View
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.socialfilmapp.R
import com.example.socialfilmapp.databinding.ItemFilmBinding
import com.example.socialfilmapp.domain.model.Film

class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemFilmBinding.bind(view)

    fun render(filmModel: Film) {
        binding.tvTitleFilm.text = filmModel.title
        Glide.with(binding.ivFilm.context).load("https://www.cnet.com/a/img/resize/3d224f21651f9747f611bdaaa9a02c16486c71a4/hub/2021/12/24/aa266356-f4e0-4498-a799-f827efe36ed5/spider-man-no-way-home-new-poster-1200.jpg?auto=webp&fit=crop&height=675&width=1200")
            .into(binding.ivFilm)
        //Glide.with(binding.ivFilm.context).load(filmModel.bannerVideo.billboard).into(binding.ivFilm)
        //itemView.setOnClickListener{onClickListener(filmModel)}
    }
}