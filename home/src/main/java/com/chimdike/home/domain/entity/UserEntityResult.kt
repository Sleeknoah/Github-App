package com.chimdike.home.domain.entity

sealed class UserEntityResult{
    data class UserSuccess(val user: UserResult): UserEntityResult()
    data class UserFailure(val message: String): UserEntityResult()
}

data class UserResult(
    val incompleteResults: Boolean,
    val items: List<UserItemResult>,
    val totalCount: Int
)

data class UserItemResult(
    val avatarUrl: String,
    val id: Int,
    val login: String,
    val nodeId: String,
    val type: String,
    val url: String
)