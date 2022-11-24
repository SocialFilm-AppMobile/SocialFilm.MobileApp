package com.example.socialfilmapp.adapter
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.socialfilmapp.domain.ApiClient
import com.example.socialfilmapp.domain.model.Film


abstract class FilmViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: T, position: Int)


}