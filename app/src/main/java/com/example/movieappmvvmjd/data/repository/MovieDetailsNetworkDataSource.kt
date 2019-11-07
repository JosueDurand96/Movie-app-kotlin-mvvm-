package com.example.movieappmvvmjd.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieappmvvmjd.data.api.TheMovieDBInterface
import com.example.movieappmvvmjd.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsNetworkDataSource(private val apiService:TheMovieDBInterface, private val compositeDisposable: CompositeDisposable) {

    private val _networkState = MutableLiveData<NetworkState>()
    val networkState:LiveData<NetworkState>
        get() = _networkState

    private val _downloadedMovieDetailsResponse = MutableLiveData<MovieDetails>()
    val downloadedMovieResponse: LiveData<MovieDetails>
        get() = _downloadedMovieDetailsResponse

    fun fetchMovieDetails(movieId:Int){

    }


}