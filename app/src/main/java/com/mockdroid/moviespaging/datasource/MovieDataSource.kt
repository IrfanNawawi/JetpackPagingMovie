package com.mockdroid.moviespaging.datasource

import androidx.paging.PageKeyedDataSource
import com.mockdroid.moviespaging.model.ResultsItem
import com.mockdroid.moviespaging.network.Network
import com.mockdroid.moviespaging.network.Routes
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDataSource : PageKeyedDataSource<Long, ResultsItem>() {

    var api: Routes

    init {
        api = Network.services()
    }

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ResultsItem>
    ) {
        api.getListMovies("b64d761def5c00e40e6a36e0032741bf", "en-US", 1, params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->
                t.results?.let { callback.onResult(it, null, 2L) }
            }, {})
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {

    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {
        api.getListMovies(
            "b64d761def5c00e40e6a36e0032741bf",
            "en-US",
            params.key,
            params.requestedLoadSize
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->
                t.results?.let { callback.onResult(it, params.key + 1) }
            }, {})
    }
}