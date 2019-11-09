package com.example.movieappmvvmjd.single_movie_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
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

        movieRepository = MovieDetailsRepository(apiService)

        viewModel = getViewModel(movieId)
    }

    private fun getViewModel(movieId: Int): SingleMovieViewModel {
        return ViewModelProviders.of(this,object :ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return SingleMovieViewModel(movieRepository,movieId) as T
            }
        })[SingleMovieViewModel::class.java]
    }
}
