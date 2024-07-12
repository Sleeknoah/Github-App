package com.chimdike.home.data.dto



data class UserInfoDto(
    val avatarUrl: String,
    val bio: String,
    val email: String,
    val followers: Int,
    val following: Int,
    val htmlUrl: String,
    val location: String,
    val login: String,
    val name: String,
    val publicRepos: Int
)
