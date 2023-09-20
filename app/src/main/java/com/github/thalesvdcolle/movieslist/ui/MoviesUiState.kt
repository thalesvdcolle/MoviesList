package com.github.thalesvdcolle.movieslist.ui

import com.github.thalesvdcolle.movieslist.data.Movie

data class MoviesUiState(
    val movies : List<Movie> = listOf()
)
