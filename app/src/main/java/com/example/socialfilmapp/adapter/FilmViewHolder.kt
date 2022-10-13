package com.example.socialfilmapp.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.socialfilmapp.ExtraInfoFilmActivity
import com.example.socialfilmapp.databinding.ItemFilmBinding
import com.example.socialfilmapp.domain.model.Film

class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemFilmBinding.bind(view)

    fun render(filmModel: Film) {
        //binding.tvTitleFilm.text = filmModel.title
        Glide.with(binding.ivFilm.context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ66hp45EpExGHx-1Bd8q1DItazQO2mBTygNA&usqp=CAU")
            .into(binding.ivFilm)
        //Glide.with(binding.ivFilm.context).load(filmModel.bannerVideo.billboard).into(binding.ivFilm)
        binding.ivFilm.setOnClickListener { onClickListener(filmModel) }
    }

    private fun onClickListener(filmModel: Film) {
        println("film click $filmModel")
        /*val intent = Intent(binding.ivFilm.context as Context, ExtraInfoFilmActivity::class.java)
        intent.putExtra("FILM_TITLE", filmModel.title)
        startActivity(binding.ivFilm.context ,intent,null)*/
    }
}