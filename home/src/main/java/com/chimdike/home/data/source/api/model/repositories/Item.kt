package com.chimdike.home.data.source.api.model.repositories


import com.squareup.moshi.Json

data class Item(
    @Json(name = "description")
    val description: String? = "",
    @Json(name = "full_name")
    val fullName: String,
    @Json(name = "language")
    val language: String?,
    @Json(name = "name")
    val name: String,
    @Json(name = "owner")
    val owner: Owner,
    @Json(name = "stargazers_count")
    val stargazersCount: Int? = 0,
    @Json(name = "topics")
    val topics: List<String>? = emptyList(),
    @Json(name = "visibility")
    val visibility: String
)