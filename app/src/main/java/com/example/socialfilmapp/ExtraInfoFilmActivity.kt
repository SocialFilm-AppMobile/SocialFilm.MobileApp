package com.example.socialfilmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ExtraInfoFilmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extra_info_film)

        val txtTitle = findViewById<TextView>(R.id.tvInfoTitleFilm)
        val txtSynopsis = findViewById<TextView>(R.id.tvInfoSynopsisFilm)
        val txtCategory = findViewById<TextView>(R.id.tvInfoCategoryFilm)
        val imgFilm = findViewById<ImageView>(R.id.ivInfoImageFilm)

        val bundle = intent.extras
        txtTitle.text = bundle?.get("FILM_TITLE").toString()
        txtSynopsis.text = bundle?.get("FILM_SYNOPSIS").toString()
        txtCategory.text = bundle?.get("FILM_CATEGORY").toString()
        //Glide.with(imgFilm.context).load(bundle?.get("FILM_IMAGE_BILLBOARD").toString()).into(imgFilm)
        Glide.with(imgFilm.context).load("https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2013/12/266199-banner-oficial-nuevas-fotos-amazing-spider-man-2.jpg?itok=ddNUjFCx")
            .into(imgFilm)
    }
}