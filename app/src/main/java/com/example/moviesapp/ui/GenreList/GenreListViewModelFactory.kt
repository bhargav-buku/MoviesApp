package com.example.moviesapp.ui.GenreList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.repository.GenreRepository

@Suppress("UNCHECKED_CAST")
class GenreListViewModelFactory(private val repository: GenreRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GenreListViewModel(repository) as T
    }
}