package com.mockdroid.moviespaging.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.mockdroid.moviespaging.datasource.factory.MovieDataFactory
import com.mockdroid.moviespaging.model.ResultsItem
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MovieViewModel : ViewModel() {

    var executor: Executor
    var movieData: LiveData<PagedList<ResultsItem>>

    init {
        executor = Executors.newFixedThreadPool(5)
        var movieFactory = MovieDataFactory()
        var pageListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(15)
            .setEnablePlaceholders(false)
            .build()

        movieData = LivePagedListBuilder(movieFactory, pageListConfig)
            .setFetchExecutor(executor)
            .build()
    }

    fun getMovies(): LiveData<PagedList<ResultsItem>> {
        return movieData
    }
}