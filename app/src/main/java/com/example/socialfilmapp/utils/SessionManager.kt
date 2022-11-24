package com.example.socialfilmapp.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.socialfilmapp.R
import com.example.socialfilmapp.domain.model.User
import com.example.socialfilmapp.domain.model.UserResponse


class SessionManager(context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
        const val USER_ID = "user_id"
        const val FIRST_NAME = "firstName"
        const val LAST_NAME = "lastName"
        const val EMAIL = "email"
        const val PASSWORD = "password"
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun saveUserId(id: Int) {
        val editor = prefs.edit()
        editor.putInt(USER_ID, id)
        editor.apply()
    }

    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    fun fetchUserId(): Int {
        return prefs.getInt(USER_ID, 0)
    }

    fun wipe() {
        prefs.edit().clear().apply()
    }

    fun saveUserData(fname: String, lname: String, email: String, password: String) {
        val editor = prefs.edit()
        editor.putString(FIRST_NAME, fname)
        editor.putString(LAST_NAME, lname)
        editor.putString(EMAIL, email)
        editor.putString(PASSWORD, password)
        editor.apply()
    }

    fun fetchUserData(): UserResponse {
        var fname = prefs.getString(FIRST_NAME, "No FirstName").toString()
        var lname = prefs.getString(LAST_NAME, "No LastName").toString()
        var email = prefs.getString(EMAIL, "No Email").toString()
        var pass = prefs.getString(PASSWORD, "No Password").toString()
        return UserResponse(fname, lname, email, pass)
    }

}