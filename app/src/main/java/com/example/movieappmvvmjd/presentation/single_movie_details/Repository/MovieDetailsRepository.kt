package com.example.movieappmvvmjd.presentation.single_movie_details.Repository

import androidx.lifecycle.LiveData
import com.example.movieappmvvmjd.model.data.api.TheMovieDBInterface
import com.example.movieappmvvmjd.model.data.repository.MovieDetailsNetworkDataSource
import com.example.movieappmvvmjd.model.data.repository.NetworkState
import com.example.movieappmvvmjd.model.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository(private val apiService: TheMovieDBInterface) {
    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSigleMovieDetails(
        compositeDisposable: CompositeDisposable,
        movieId: Int
    ): LiveData<MovieDetails> {
        movieDetailsNetworkDataSource =
            MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }

}