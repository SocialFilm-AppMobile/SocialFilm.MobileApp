package com.example.socialfilmapp

import com.example.socialfilmapp.domain.model.Film

interface FilmsListener {
    fun onItemClick(film: Film)
}