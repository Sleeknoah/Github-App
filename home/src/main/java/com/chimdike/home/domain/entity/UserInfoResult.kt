package com.chimdike.home.domain.entity

sealed class UserInfoResult {
    data class Success(val result: UserInfoEntity) : UserInfoResult()
    data class Failure(val message: String) : UserInfoResult()
}

data class UserInfoEntity(
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
