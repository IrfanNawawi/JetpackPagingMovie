package com.mockdroid.moviespaging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mockdroid.moviespaging.adapter.MovieListAdapter
import com.mockdroid.moviespaging.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var viewModel: MovieViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        viewModel?.getMovies()?.observe(this, Observer {
            val adapter = MovieListAdapter()
            adapter.submitList(it)
            rv_movie.adapter = adapter
        })
    }
}