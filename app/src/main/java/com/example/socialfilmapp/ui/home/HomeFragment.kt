package com.example.socialfilmapp.ui.home

import PlaceHolderApi.PlaceHolderApi
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.socialfilmapp.ExtraInfoFilmActivity
import com.example.socialfilmapp.FilmsListener
import com.example.socialfilmapp.R
import com.example.socialfilmapp.adapter.Adapter
import com.example.socialfilmapp.adapter.CategoryAdapter
import com.example.socialfilmapp.databinding.FragmentHomeBinding
import com.example.socialfilmapp.domain.ApiClient
import com.example.socialfilmapp.domain.model.Film
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    lateinit var service: PlaceHolderApi
    lateinit var apiClient: ApiClient

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var filmCategoryListAdapter=CategoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        apiClient = ApiClient()
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.filmCategories.apply {
            adapter = filmCategoryListAdapter
        }

        filmCategoryListAdapter.setFilmClickListener {
            val intent = Intent(context, ExtraInfoFilmActivity::class.java)
            intent.putExtra("FILM_TITLE",it.title)
            intent.putExtra("FILM_SYNOPSIS",it.synopsis)
            intent.putExtra("FILM_CATEGORY",it.category.name)
            intent.putExtra("FILM_IMAGE_BILLBOARD",it.bannerVideo.billboard)
            startActivity(intent)
            Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
        }
        homeViewModel.categoryList.observe(viewLifecycleOwner){
            filmCategoryListAdapter.submitList(it)

        }
        homeViewModel.getFilmsCat()


        return root

    }
    private fun algo(id:Int) {

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}