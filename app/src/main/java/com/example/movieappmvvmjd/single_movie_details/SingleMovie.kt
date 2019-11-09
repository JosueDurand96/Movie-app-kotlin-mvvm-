package com.example.movieappmvvmjd.single_movie_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieappmvvmjd.R
import com.example.movieappmvvmjd.data.api.TheMovieDBClient
import com.example.movieappmvvmjd.data.api.TheMovieDBInterface
import com.example.movieappmvvmjd.single_movie_details.Repository.MovieDetailsRepository
import com.example.movieappmvvmjd.single_movie_details.ViewModel.SingleMovieViewModel

class SingleMovie : AppCompatActivity() {

    private lateinit var viewModel: SingleMovieViewModel
    private lateinit var movieRepository: MovieDetailsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_movie)
        val movieId: Int = 1

        val apiService: TheMovieDBInterface = TheMovieDBClient.getClient()


    }
}
