package com.mockdroid.moviespaging.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mockdroid.moviespaging.R
import com.mockdroid.moviespaging.model.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieListAdapter :
    PagedListAdapter<ResultsItem, RecyclerView.ViewHolder>(ResultsItem().diff_callback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MovieHolder) {
            holder.bindTo(getItem(position))
        }
    }

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindTo(item: ResultsItem?) {
            itemView.tvTitle.text = item?.name
            itemView.tvOverview.text = item?.description

            val urlImage = "https://image.tmdb.org/t/p/w500"
            Picasso.get()
                .load(urlImage+ item?.posterPath)
                .into(itemView.imgMovie)
        }

    }
}