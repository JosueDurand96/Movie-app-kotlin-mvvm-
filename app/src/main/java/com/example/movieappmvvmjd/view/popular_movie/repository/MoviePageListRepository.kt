package com.example.movieappmvvmjd.view.popular_movie.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.movieappmvvmjd.model.data.api.POST_PER_PAGE
import com.example.movieappmvvmjd.model.data.api.TheMovieDBInterface
import com.example.movieappmvvmjd.model.data.repository.MovieDataSource
import com.example.movieappmvvmjd.model.data.repository.MovieDataSourceFactory
import com.example.movieappmvvmjd.model.data.repository.NetworkState
import com.example.movieappmvvmjd.model.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable

class MoviePageListRepository(private val apiService: TheMovieDBInterface) {
    lateinit var moviePagedList: LiveData<PagedList<Movie>>
    lateinit var moviesDataSourceFactory: MovieDataSourceFactory

    fun fetchLiveMoviePagedList(compositeDisposable: CompositeDisposable): LiveData<PagedList<Movie>> {
        moviesDataSourceFactory = MovieDataSourceFactory(apiService, compositeDisposable)

        val config: PagedList.Config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(POST_PER_PAGE)
            .build()

        moviePagedList = LivePagedListBuilder(moviesDataSourceFactory, config).build()
        return moviePagedList
    }

    fun getNetworkState():LiveData<NetworkState>{
        return Transformations.switchMap<MovieDataSource,NetworkState>(
                moviesDataSourceFactory.moviesLiveDataSource, MovieDataSource::networkState
        )
    }

}