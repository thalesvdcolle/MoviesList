package com.github.thalesvdcolle.movieslist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.github.thalesvdcolle.movieslist.data.Movie

@Composable
fun Movie(movie: Movie, modifier: Modifier = Modifier) {
    
    Row {
    AsyncImage(model = movie.image, contentDescription = null)

        Text(
            text = movie.name,
            modifier = modifier
        )
    }
}

@Composable
fun MoviesList(
    moviesViewModel: MoviesViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val movieState by moviesViewModel.moviesUiState.collectAsState()
    Column() {
        movieState.movies.forEach { movie ->
            Movie(movie = movie)
        }
    }
}