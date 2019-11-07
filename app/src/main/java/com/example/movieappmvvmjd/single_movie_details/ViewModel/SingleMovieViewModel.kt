package com.example.movieappmvvmjd.single_movie_details.ViewModel

import androidx.lifecycle.ViewModel
import com.example.movieappmvvmjd.single_movie_details.Repository.MovieDetailsRepository

class SingleMovieViewModel(private val movieDetailsRepository: MovieDetailsRepository,movieId:Int):ViewModel() {

}