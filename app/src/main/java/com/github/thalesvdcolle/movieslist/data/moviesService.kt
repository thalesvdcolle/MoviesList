package com.github.thalesvdcolle.movieslist.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MoviesService {
    @GET(""?apikey=e9579417")
    fun searchMovies(@Query("s")searchQuery: String): Response<SearchResponse>

}
val moviesService = retrofit.create(MoviesService::class.java)
val movies = listOf(
    "tranformers1",
    "tranformers2",
    "titanic",
    "tranformers3"
)
