package com.example.socialfilmapp.ui.notifications

import PlaceHolderApi.PlaceHolderApi
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.socialfilmapp.ExtraInfoFilmActivity
import com.example.socialfilmapp.KeepSession.Companion.prefs
import com.example.socialfilmapp.LoginActivity
import com.example.socialfilmapp.databinding.FragmentNotificationsBinding
import com.example.socialfilmapp.domain.model.BannerVideo
import com.example.socialfilmapp.domain.model.SaveFilm
import com.example.socialfilmapp.domain.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NotificationsFragment : Fragment() {

    lateinit var service: PlaceHolderApi

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            //textView.text = it
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://socialfilm.azurewebsites.net/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create<PlaceHolderApi>(PlaceHolderApi::class.java)
        println("serviceeeeeeeeeeeeees $service")

        getUser()

        return root
    }

    private fun getUser() {
        println(prefs.fetchUserData())
        binding.tvFirstUserName.text = prefs.fetchUserData().firstName.toString()
        binding.tvLastUserName.text = prefs.fetchUserData().lastName
        binding.tvEmail.text = prefs.fetchUserData().email
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}