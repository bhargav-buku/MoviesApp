package com.example.moviesapp.ui.GenreList

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.data.Genre
import kotlinx.android.synthetic.main.recyclerview_genre.view.*

class GenreListViewHolder(
    itemView: View
): RecyclerView.ViewHolder(itemView) {

    val btn = itemView.genre

    fun bind(item: Genre) {
        btn.text = item.name
    }

}