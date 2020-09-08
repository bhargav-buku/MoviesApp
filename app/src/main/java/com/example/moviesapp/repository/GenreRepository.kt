package com.example.moviesapp.repository

import com.example.moviesapp.network.ApiService
import com.example.moviesapp.network.GenreListApiRequest

class GenreRepository( private val api: ApiService) : GenreListApiRequest() {

    suspend fun getGenreList(api_key : String) = apiRequest { api.getGenreList(api_key) }

}