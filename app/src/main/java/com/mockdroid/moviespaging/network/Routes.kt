package com.mockdroid.moviespaging.network

import com.mockdroid.moviespaging.model.Movies
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface Routes {

    @GET("5/lists")
    fun getListMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Long,
        @Query("pageSize") pageSize: Int
    ): Flowable<Movies>
}