package com.example.moviesapp.ui.GenreList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.Genre

class GenreListAdapter(private val genreList: List<Genre>) : RecyclerView.Adapter<GenreListViewHolder>() {

    override fun getItemCount() = genreList.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, tag: Int): GenreListViewHolder {
        return GenreListViewHolder(
            LayoutInflater.from(
                viewGroup.context
            ).inflate(
                R.layout.recyclerview_genre,
                viewGroup,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GenreListViewHolder, position: Int) {
        val results = genreList ?: return
        val result = results[position] ?: return
        holder.bind(result)
    }

}