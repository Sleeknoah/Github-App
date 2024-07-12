package com.chimdike.home.data.source.api.model.repositories



import com.squareup.moshi.Json

data class RepositoryResponse(
    @Json(name="incomplete_results")
    val incompleteResults: Boolean,
    @Json(name= "items")
    val items: List<Item>,
    @Json(name = "total_count")
    val totalCount: Int
)