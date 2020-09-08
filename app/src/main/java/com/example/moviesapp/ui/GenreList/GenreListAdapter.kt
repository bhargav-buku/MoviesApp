package com.example.moviesapp.ui.GenreList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.Genre
import com.example.moviesapp.databinding.RecyclerviewGenreBinding
import kotlinx.android.synthetic.main.activity_genre_list.view.*

class GenreListAdapter(private val genreList: List<Genre>) : RecyclerView.Adapter<GenreListAdapter.GenreListViewHolder> {


    override fun getItemCount() = genreList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GenreListViewHolder(
            DataBindingUtil.inflate<RecyclerviewGenreBinding>(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_genre,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: GenreListViewHolder, position: Int) {
        holder.recyclerviewGenreBinding.genre = genreList[position]
    }


    inner class GenreListViewHolder(
        val recyclerviewGenreBinding: RecyclerviewGenreBinding
    ) : RecyclerView.ViewHolder(recyclerviewGenreBinding.root)

}