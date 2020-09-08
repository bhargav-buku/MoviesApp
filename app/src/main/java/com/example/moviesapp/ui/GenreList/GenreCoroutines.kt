package com.example.moviesapp.ui.GenreList

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object GenreCoroutines{

    fun<T: Any> ioTheMain(work: suspend (() -> T?),callback: ((T?)->Unit)) =

        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async rt@{

                return@rt work()

            }.await()

            callback(data)

    }
}