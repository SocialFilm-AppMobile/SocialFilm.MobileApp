package com.example.socialfilmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.socialfilmapp.KeepSession.Companion.prefs

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initUI()
    }
    fun initUI(){
        var signout:Button=findViewById(R.id.buttonOut)
        signout.setOnClickListener{
            prefs.wipe()
            onBackPressed()
        }
    }
}