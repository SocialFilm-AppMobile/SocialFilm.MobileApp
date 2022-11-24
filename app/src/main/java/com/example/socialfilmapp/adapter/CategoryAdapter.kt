package com.example.socialfilmapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.socialfilmapp.databinding.FragmentHomeBinding
import com.example.socialfilmapp.databinding.ItemCategoryFilmBinding
import com.example.socialfilmapp.databinding.ItemFilmBinding
import com.example.socialfilmapp.domain.ApiClient
import com.example.socialfilmapp.domain.model.Category
import com.example.socialfilmapp.domain.model.Film
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response

class CategoryAdapter(): ListAdapter<Category, FilmViewHolder<*>>(DiffUtilCallback) {

    private object DiffUtilCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean = oldItem.name == newItem.name
        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean = oldItem == newItem
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder<*> {
        val itemBinding = ItemCategoryFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BindViewHolderList(itemBinding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder<*>, position: Int) {
        when (holder) {
            is BindViewHolderList -> holder.bind(getItem(position), position)
        }
    }
    inner class BindViewHolderList(private val binding: ItemCategoryFilmBinding) : FilmViewHolder<Category>(binding.root) {

        override fun bind(item: Category, position: Int) = with(binding) {

            categoryName.text = item.name

            val movieListAdapter = Adapter()

            recyclerViewFilms.apply {
                adapter = movieListAdapter
            }

            movieListAdapter.setFilmClickListener {
                onMovieClickListener?.let { click ->
                    click(it)
                }
            }
            ApiClient().getApiServiceNI().getFilmsbyCategory(item.id)
                .enqueue(object : Callback<List<Film>> {
                    override fun onResponse(call: Call<List<Film>>, response: Response<List<Film>>) {
                        item.listFilms= response.body()!!
                        movieListAdapter.submitList(item.listFilms)
                    }

                    override fun onFailure(call: Call<List<Film>>, t: Throwable) {
                        println("error")
                    }
                })
           //movieListAdapter.submitList(item.listFilms)

        }
    }

    private var onMovieClickListener: ((Film) -> Unit)? = null

    fun pushFilms(film:Film){

    }



    fun setFilmClickListener(listener: (Film) -> Unit) {
        onMovieClickListener = listener
    }


}