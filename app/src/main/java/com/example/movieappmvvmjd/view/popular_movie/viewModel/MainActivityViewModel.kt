package com.example.movieappmvvmjd.view.popular_movie.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.movieappmvvmjd.model.data.repository.NetworkState
import com.example.movieappmvvmjd.model.data.vo.Movie
import com.example.movieappmvvmjd.view.popular_movie.repository.MoviePageListRepository
import io.reactivex.disposables.CompositeDisposable

class MainActivityViewModel(private val movieRepository: MoviePageListRepository) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val moviePageList: LiveData<PagedList<Movie>> by lazy {
        movieRepository.fetchLiveMoviePagedList(compositeDisposable)
    }

    val networkState: LiveData<NetworkState> by lazy {
        movieRepository.getNetworkState()
    }

    fun listIsEmpty(): Boolean {
        return moviePageList.value?.isEmpty() ?: true
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}