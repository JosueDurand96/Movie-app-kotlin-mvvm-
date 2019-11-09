package com.example.movieappmvvmjd.data.vo

import com.google.gson.annotations.SerializedName

data class Movie(
    val int: Int,
    @SerializedName("poster_path")
    val poster_path:String,
    @SerializedName("release_date")
    val releaseDate:String,
    val title:String
)