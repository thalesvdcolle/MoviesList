package com.github.thalesvdcolle.movieslist.data

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Title") val name : String,
    @SerializedName("Poster") val image : String
)
