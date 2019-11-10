package com.example.movieappmvvmjd.ui.popular_movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieappmvvmjd.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel

    lateinit var  moviePageListRepository: MoviePageListRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
