package com.mockdroid.moviespaging.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Movies(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)

data class ResultsItem(

	@field:SerializedName("item_count")
	val itemCount: Int? = null,

	@field:SerializedName("list_type")
	val listType: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("favorite_count")
	val favoriteCount: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("iso_639_1")
	val iso6391: String? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	var diff_callback: DiffUtil.ItemCallback<ResultsItem> = object :
		DiffUtil.ItemCallback<ResultsItem>() {
		override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
			return oldItem.name == newItem.name
		}

		override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
			return oldItem.equals(newItem)
		}

	}
)
