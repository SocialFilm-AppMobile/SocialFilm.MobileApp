package com.example.socialfilmapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide

import com.example.socialfilmapp.databinding.ItemFilmBinding
import com.example.socialfilmapp.domain.ApiClient
import com.example.socialfilmapp.domain.model.Film

class Adapter(): ListAdapter<Film,FilmViewHolder<*>>(DiffUtilCallback){

    private object DiffUtilCallback:DiffUtil.ItemCallback<Film>(){
        override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean = oldItem.title == newItem.title
        override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder<*> {
        val itemFilmBinding=ItemFilmBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BindViewHolderClass(itemFilmBinding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder<*>, position: Int) {
        when(holder){
            is BindViewHolderClass->holder.bind(getItem(position),position)
        }
    }


    inner class BindViewHolderClass(private val binding: ItemFilmBinding):FilmViewHolder<Film>(binding.root){
        override fun bind(item: Film, position: Int)= with(binding) {
            Glide.with(ivFilm.context).load(item.bannerVideo.billboard).into(ivFilm)
            ivFilm.setOnClickListener{
                onFilmClickListener?.let { click->
                    click(item)
                }
            }
        }
    }
    private var onFilmClickListener:((Film)->Unit)?=null

    fun setFilmClickListener(listener: (Film)->Unit){
        onFilmClickListener=listener
    }





}