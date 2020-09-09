package com.example.moviesapp.ui.GenreList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.Genre
import com.example.moviesapp.repository.GenreRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class GenreListViewModel(private val repository: GenreRepository) : ViewModel() {

    private lateinit var job: Job

    private val _genreList = MutableLiveData<List<Genre>>()
    val genreList : LiveData<List<Genre>>
        get() = _genreList

    init {
        getGenreList()
    }

    fun getGenreList() {
        viewModelScope.launch {
            // RUN ANY ASYNC FUNCTIONS
            val genres = repository.getGenreList("81eb045d6741c92600537274a436861c")

            _genreList.value = genres
        }
    }

    override fun onCleared(){
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }

}