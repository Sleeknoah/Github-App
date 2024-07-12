package com.chimdike.home.domain.usecase

import com.chimdike.home.domain.entity.RepositoryEntityResult
import com.chimdike.home.domain.entity.UserEntityResult
import com.chimdike.home.domain.repository.UserRepository
import javax.inject.Inject

interface SearchRepositoriesUsecase{
    suspend fun execute (
        query: String,
    ): RepositoryEntityResult
}

internal class SearchRepositoriesUsecaseImpl @Inject constructor(
    private val repository: UserRepository
): SearchRepositoriesUsecase{
    override suspend fun execute(
        query: String,
    ): RepositoryEntityResult {
        return repository.getRepositories(query)
    }
}