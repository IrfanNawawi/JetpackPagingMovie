package com.mockdroid.moviespaging.datasource.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.mockdroid.moviespaging.datasource.MovieDataSource
import com.mockdroid.moviespaging.model.ResultsItem

class MovieDataFactory : DataSource.Factory<Long, ResultsItem>() {
    var mutableLivedata: MutableLiveData<MovieDataSource>
    var movieDataSource: MovieDataSource

    init {
        mutableLivedata = MutableLiveData()
        movieDataSource = MovieDataSource()
    }

    override fun create(): DataSource<Long, ResultsItem> {
        mutableLivedata.postValue(movieDataSource)
        return movieDataSource
    }

    fun getMutableLiveData(): MutableLiveData<MovieDataSource> {
        return mutableLivedata
    }
}