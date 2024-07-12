package com.chimdike.home.domain.entity


sealed class UserRepositoryEntityResult{
    data class Success(val result: List<UserRepositoryItemResult>): UserRepositoryEntityResult()
    data class Failure(val message: String): UserRepositoryEntityResult()
}
data class UserRepositoryItemResult(
    val description: String,
    val fullName: String,
    val language: String,
    val name: String,
    val stargazersCount: Int,
    val topics: List<String>,
    val visibility: String
)