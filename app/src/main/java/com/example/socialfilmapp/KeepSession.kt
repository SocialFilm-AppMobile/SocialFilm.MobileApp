package com.example.socialfilmapp

import android.app.Application
import com.example.socialfilmapp.utils.SessionManager

class KeepSession :Application(){
    companion object{
        lateinit var prefs:SessionManager
    }

    override fun onCreate() {
        super.onCreate()
        prefs=SessionManager(applicationContext)
    }
}