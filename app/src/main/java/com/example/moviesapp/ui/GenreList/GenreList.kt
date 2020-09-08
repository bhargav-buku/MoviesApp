package com.example.moviesapp.ui.GenreList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.network.ApiService
import com.example.moviesapp.repository.GenreRepository
import kotlinx.android.synthetic.main.activity_genre_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GenreList : AppCompatActivity() {

    private lateint var factory : GenreListViewModelFactory
    private lateint var viewModel: GenreListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = ApiService()
        val repository = GenreRepository(api)
        factory = GenreListViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this,factory).get(GenreListViewModel::class.java)
        viewModel.getGenreList()
        viewModel.genreList.observe(viewLifecycleOwner, Observer{genreList ->
            recycler_view_genre.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = GenreListAdapter(genreList)
            }
        })


        setContentView(R.layout.activity_genre_list)

//        val repository = GenreRepository(ApiService())
//        GlobalScope.launch (Dispatchers.Main) {
//            val genreList = repository.getGenreList("81eb045d6741c92600537274a436861c")
//
//            Toast.makeText(this@GenreList,genreList.toString(),Toast.LENGTH_LONG).show()
//        }

    }
}