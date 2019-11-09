package com.example.movieappmvvmjd.data.api

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

const val API_KEY = "99d85c25122fe5055a7ca95e57f408fd"
const val BASE_URL = "https://api.themoviedb.org/3/"
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"


    //https://api.themoviedb.org/3/movie/550?api_key=99d85c25122fe5055a7ca95e57f408fd

    //https://api.themoviedb.org/3/popular?api_key=99d85c25122fe5055a7ca95e57f408fd
    //https://api.themoviedb.org/3/movie/2999534?api_key=99d85c25122fe5055a7ca95e57f408fd
    //https://image.tmdb.org/t/p/w342/or06FN3Dka5tukK1e9sl16pB3iy.jpg
object TheMovieDBClient {
        fun getClient(): TheMovieDBInterface{
            val requestInterceptor = Interceptor{chain ->
                //Inteceptor take only one argument  which is a  lambda function so parenthesis can be omitted

                val url:HttpUrl = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("api_key", API_KEY)
                    .build()
                val request: Request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request) // explicity return  a value from @annotation. Lambda always returns the value
            }
            val okHttpClient:  OkHttpClient= OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .connectTimeout(60,TimeUnit.SECONDS)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TheMovieDBInterface::class.java)
        }
}