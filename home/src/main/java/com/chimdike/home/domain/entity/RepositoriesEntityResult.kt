package com.chimdike.home.domain.entity

sealed class RepositoryEntityResult{
    data class Success(val result: RepositoriesResult): RepositoryEntityResult()
    data class Failure(val message: String): RepositoryEntityResult()
}

data class RepositoriesResult(
    val incompleteResults: Boolean,
    val items: List<RepositoryItemResult>,
    val totalCount: Int
)

data class RepositoryItemResult(
    val description: String,
    val fullName: String,
    val language: String,
    val name: String,
    val owner: OwnerResult,
    val stargazersCount: Int,
    val topics: List<String>,
    val visibility: String
)

data class OwnerResult(
    val avatarUrl: String,
    val login: String
)