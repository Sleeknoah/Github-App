package com.chimdike.home.data.source.api.model.users


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserInfoResponse(
    @Json(name = "avatar_url")
    val avatarUrl: String?,
    @Json(name = "bio")
    val bio: String?,
    @Json(name = "email")
    val email: String?,
    @Json(name = "followers")
    val followers: Int?,
    @Json(name = "following")
    val following: Int?,
    @Json(name = "html_url")
    val htmlUrl: String?,
    @Json(name = "location")
    val location: String?,
    @Json(name = "login")
    val login: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "public_repos")
    val publicRepos: Int?
)