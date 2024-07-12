package com.chimdike.home.data.source.api.model.repositories


import com.squareup.moshi.Json

data class Owner(
    @Json(name = "avatar_url")
    val avatarUrl: String,
    @Json(name = "login")
    val login: String
)