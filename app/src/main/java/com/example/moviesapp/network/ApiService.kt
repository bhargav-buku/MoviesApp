package com.example.moviesapp.network


import com.example.moviesapp.data.Genre
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// Following apis are to be used
// https://api.themoviedb.org/3/genre/movie/list?api_key=81eb045d6741c92600537274a436861c
// https://api.themoviedb.org/3/list/{list_id}?api_key=81eb045d6741c92600537274a436861c
// https://api.themoviedb.org/3/movie/{movie_id}?api_key=81eb045d6741c92600537274a436861c

interface ApiService {

    @GET("/genre/movie/list/")
    suspend fun getGenreList(@Query("api_key") api_key : String ) : Response<List<Genre>>

    companion object{
        operator fun invoke() : ApiService{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.themoviedb.org/3/")
                .build()
                .create(ApiService::class.java)
        }
    }

//    @GET("/genre/movie/list/{list_id}")
//    suspend fun getMoviesList(@Path("list_id") id: Int): Call<>


}