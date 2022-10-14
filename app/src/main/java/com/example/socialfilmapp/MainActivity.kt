package com.example.socialfilmapp

import PlaceHolderApi.PlaceHolderApi
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.socialfilmapp.KeepSession.Companion.prefs
import com.example.socialfilmapp.adapter.Adapter
import com.example.socialfilmapp.domain.ApiClient
import com.example.socialfilmapp.domain.model.Film
import com.example.socialfilmapp.domain.request.LoginRequest
import com.example.socialfilmapp.domain.responses.LoginResponse
import com.example.socialfilmapp.utils.SessionManager

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var service: PlaceHolderApi

    lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiClient = ApiClient()
        initUI()
        checkUserValue()
    }
    fun checkUserValue(){
        if(prefs.fetchUserId()!=0){
            goToHome()
        }
    }
    fun initUI(){
        var btnSignIn:Button=findViewById(R.id.button)
        btnSignIn.setOnClickListener{accesToDetail()}
    }

    fun accesToDetail(){
        var email:EditText=findViewById(R.id.editTextTextEmailAddress)
        var password:EditText=findViewById(R.id.editTextTextPassword)

        if(email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
            apiClient.getApiService(this).login(LoginRequest(email=email.text.toString(), password = password.text.toString()))
                .enqueue(object:Callback<LoginResponse>{
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, "An error has occurred",Toast.LENGTH_LONG).show()
                    }
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        val loginResponse=response.body()
                        if(loginResponse!=null){
                            prefs.saveAuthToken(loginResponse.token)
                            prefs.saveUserId(loginResponse.id)
                            goToHome()
                        }else{
                            Toast.makeText(applicationContext, "Email or password incorrect",Toast.LENGTH_LONG).show()
                        }

                    }
                })


        }else{
            Toast.makeText(applicationContext,"Please complete all fields",Toast.LENGTH_LONG).show()
        }
    }
    fun goToHome(){
        startActivity(Intent(this,HomeActivity::class.java))
    }

}