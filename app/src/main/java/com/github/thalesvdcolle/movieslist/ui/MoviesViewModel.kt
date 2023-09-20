package com.github.thalesvdcolle.movieslist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.thalesvdcolle.movieslist.data.MoviesService
import com.github.thalesvdcolle.movieslist.data.moviesService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val moviesService: MoviesService) : ViewModel() {
    private val _moviesState = MutableStateFlow(MoviesUiState())
    val moviesUiState: StateFlow<MoviesUiState>
        get() = _moviesState

    init {
        searchMovies()
    }

    fun searchMovies(){
        viewModelScope.launch {
            val response = moviesService.searchMovies("transformers")
            if (response.isSuccessful) {
                _moviesState.update {currentState ->
                    currentState.copy(
                        movies = response.body()?.movies ?: listOf()
                    )
                }
            }
        }
    }
}
