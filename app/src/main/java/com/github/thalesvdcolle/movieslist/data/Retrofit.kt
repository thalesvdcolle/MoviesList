package com.github.thalesvdcolle.movieslist.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit = Retrofit.Builder()
    .baseUrl("https://www.omdbapi.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()