package com.example.moviesapp.ui.GenreList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.Genre
import com.example.moviesapp.network.ApiService
import com.example.moviesapp.repository.GenreRepository
import kotlinx.android.synthetic.main.activity_genre_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GenreListActivity : AppCompatActivity() {

    private lateinit var factory : GenreListViewModelFactory
    private lateinit var viewModel : GenreListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_genre_list)

        val api = ApiService()
        val repository = GenreRepository(api)
        factory = GenreListViewModelFactory(repository)

        viewModel = ViewModelProviders.of(this,factory).get(GenreListViewModel::class.java)

        viewModel.genreList.observe(this, Observer{
            setupRecyclerView(it)
        })
    }

    private fun setupRecyclerView(items: List<Genre>) {
        recycler_view_genre.also {
            it.layoutManager = LinearLayoutManager(this)
            it.setHasFixedSize(true)
            it.adapter = GenreListAdapter(items)
        }
    }
}