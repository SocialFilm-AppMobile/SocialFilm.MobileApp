package com.example.socialfilmapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialfilmapp.domain.ApiClient
import com.example.socialfilmapp.domain.model.Category
import com.example.socialfilmapp.domain.model.Film
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _categoryList: MutableLiveData<List<Category>> =MutableLiveData()
    val categoryList: LiveData<List<Category>>
    get()=_categoryList

    private val _filmList: MutableLiveData<List<Film>> = MutableLiveData()
    val filmList: LiveData<List<Film>>
    get()=_filmList

    fun getFilmsCat(){
        viewModelScope.launch {
            _categoryList.value=ApiClient().getApiServiceNI().getCategories().body()

        }
    }



}