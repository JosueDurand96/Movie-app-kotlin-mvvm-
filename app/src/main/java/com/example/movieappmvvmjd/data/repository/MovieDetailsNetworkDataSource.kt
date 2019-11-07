package com.example.movieappmvvmjd.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieappmvvmjd.data.api.TheMovieDBInterface
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsNetworkDataSource(private val apiService:TheMovieDBInterface, private val compositeDisposable: CompositeDisposable) {

    private val _networkState = MutableLiveData<NetworkState>()
    val networkState:LiveData<NetworkState>
        get() = _networkState


}