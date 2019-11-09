package com.example.movieappmvvmjd.data.repository

import androidx.paging.PageKeyedDataSource
import com.example.movieappmvvmjd.data.api.TheMovieDBInterface
import com.example.movieappmvvmjd.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieDataSource(private val apiService: TheMovieDBInterface, private val compositeDisposable: CompositeDisposable) : PageKeyedDataSource<Int, Movie>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
    }

}