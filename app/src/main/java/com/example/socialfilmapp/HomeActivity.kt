package com.example.socialfilmapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toolbar
import com.example.socialfilmapp.KeepSession.Companion.prefs
import com.example.socialfilmapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarConfig.toolbar3)
        val arrow:ImageView=binding.toolbarConfig.imageView

        arrow.setOnClickListener{
            onBackPressed()
        }

        initUI()
    }
    fun initUI(){
        var signout:Button=findViewById(R.id.buttonOut2)
        signout.setOnClickListener{
            prefs.wipe()
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}