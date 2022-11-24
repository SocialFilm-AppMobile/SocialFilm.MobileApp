package PlaceHolderApi

import com.example.socialfilmapp.domain.model.Film
import com.example.socialfilmapp.domain.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaceHolderApi {

    @GET("films")
    fun getAllFilms(): Call<List<Film>>

    @GET("films/{id}")
    fun getFilmId(@Path("id")id:Int):Call<Film>

    @GET("users")
    fun getAllUsers(): Call<List<User>>

    @GET("users/{id}")
    fun getUserId(@Path("id")id:Int): Call<User>
}