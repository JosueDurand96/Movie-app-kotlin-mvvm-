package com.example.movieappmvvmjd.presentation.single_movie_details.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieappmvvmjd.model.data.repository.NetworkState
import com.example.movieappmvvmjd.model.data.vo.MovieDetails
import com.example.movieappmvvmjd.presentation.single_movie_details.Repository.MovieDetailsRepository
import io.reactivex.disposables.CompositeDisposable

class SingleMovieViewModel(
    private val movieRepository: MovieDetailsRepository,
    movieId: Int
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val movieDetails: LiveData<MovieDetails> by lazy {
        movieRepository.fetchSigleMovieDetails(compositeDisposable, movieId)
    }

    val networkState: LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}