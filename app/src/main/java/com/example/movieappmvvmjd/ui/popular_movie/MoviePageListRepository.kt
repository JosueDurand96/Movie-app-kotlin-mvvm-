package com.example.movieappmvvmjd.ui.popular_movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.movieappmvvmjd.data.api.POST_PER_PAGE
import com.example.movieappmvvmjd.data.api.TheMovieDBInterface
import com.example.movieappmvvmjd.data.repository.MovieDataSource
import com.example.movieappmvvmjd.data.repository.MovieDataSourceFactory
import com.example.movieappmvvmjd.data.repository.NetworkState
import com.example.movieappmvvmjd.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.disposables.ArrayCompositeDisposable

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