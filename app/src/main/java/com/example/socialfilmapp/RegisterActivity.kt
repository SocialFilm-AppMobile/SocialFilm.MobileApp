package com.example.socialfilmapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.socialfilmapp.domain.ApiClient
import com.example.socialfilmapp.domain.request.RegisterRequest
import com.example.socialfilmapp.domain.responses.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        apiClient = ApiClient()
        initUI()
    }
    fun initUI(){
        var button:Button=findViewById(R.id.buttonSignUp)
        button.setOnClickListener{
            register()
        }
        var textgoToSignIn:TextView=findViewById(R.id.textViewSignIn)
        textgoToSignIn.setOnClickListener{startActivity(Intent(this,LoginActivity::class.java))}
    }

    fun register(){
        var first_name:EditText=findViewById(R.id.editTextFirstNameSignUp)
        var last_name:EditText=findViewById(R.id.editTextLastNameSignUp)
        var email:EditText=findViewById(R.id.editTextEmailAddressSignUp)
        var password:EditText=findViewById(R.id.PasswordSignUp)

        if(first_name.text.toString().isNotEmpty() && last_name.text.toString().isNotEmpty() && email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
            apiClient.getApiService(this).register(RegisterRequest(firstName =first_name.text.toString(), lastName =  last_name.text.toString(),email = email.text.toString(),   password = password.text.toString()))
                .enqueue(object:Callback<RegisterResponse>{
                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, "An error has occurred",Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<RegisterResponse>,
                        response: Response<RegisterResponse>
                    ) {

                        if(response.isSuccessful){
                            Toast.makeText(applicationContext, response.body()!!.messsage, Toast.LENGTH_LONG).show()
                            goToLogin()

                        }
                        else{
                            Toast.makeText(applicationContext, "An error has occurred",Toast.LENGTH_LONG).show()
                        }

                    }
                } )

        }else{
            Toast.makeText(applicationContext,"Please complete all fields",Toast.LENGTH_LONG).show()
        }
    }

    fun goToLogin(){
        startActivity(Intent(this,LoginActivity::class.java))
    }
}