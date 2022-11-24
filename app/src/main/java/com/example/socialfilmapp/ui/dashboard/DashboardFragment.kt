package com.example.socialfilmapp.ui.dashboard

import PlaceHolderApi.PlaceHolderApi
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.socialfilmapp.R
import com.example.socialfilmapp.adapter.Adapter
import com.example.socialfilmapp.databinding.FragmentDashboardBinding
import com.example.socialfilmapp.domain.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    lateinit var service: PlaceHolderApi

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val retrofit = Retrofit.Builder()
            .baseUrl("https://socialfilm.azurewebsites.net/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create<PlaceHolderApi>(PlaceHolderApi::class.java)
        println("serviceeeeeeeeeeeeees $service")
        binding.uploadFilm.setOnClickListener {
            createFilm()
        }


        return root
    }

    private fun createFilm() {
        var title: Editable? =binding.etTitulo.text
        var synopsis: Editable? =binding.etSinopsis.text
        var video: Editable? =binding.etUrlVideo.text
        var banner: Editable? =binding.etBanner.text
        var billboard: Editable? =binding.etBillboard.text
        var category: Int =binding.radioGroup.checkedRadioButtonId

        service.postFilm(SaveFilm(title = title.toString(), synopsis = synopsis.toString(), video =  video.toString(), bannerVideo = BannerVideo(billboard = billboard.toString(), Banner = banner.toString()), categoryId = category, userId = 1) ).enqueue(object : Callback<SaveFilm> {
            override fun onResponse(call: Call<SaveFilm>, response: Response<SaveFilm>) {
                response.body()
                println("cetegory -> $category")
                println("acaaaaaaaaaaaaa ${response.message()}")
            }

            override fun onFailure(call: Call<SaveFilm>, t: Throwable) {
                println("error acaaaaaaaaaaaaa")
                t?.printStackTrace()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}