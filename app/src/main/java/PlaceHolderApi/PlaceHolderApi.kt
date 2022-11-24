package PlaceHolderApi

import com.example.socialfilmapp.domain.model.Film
import com.example.socialfilmapp.domain.model.SaveFilm
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PlaceHolderApi {

    @GET("films")
    fun getAllFilms(): Call<List<Film>>

    @GET("films/{id}")
    fun getFilmId(@Path("id")id:Int):Call<Film>

    @POST("films")
    fun postFilm(@Body request: SaveFilm):Call<SaveFilm>
}