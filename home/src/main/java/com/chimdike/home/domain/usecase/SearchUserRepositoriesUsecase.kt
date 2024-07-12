package com.chimdike.home.domain.usecase

import com.chimdike.home.domain.entity.RepositoryEntityResult
import com.chimdike.home.domain.entity.UserEntityResult
import com.chimdike.home.domain.entity.UserRepositoryEntityResult
import com.chimdike.home.domain.repository.UserRepository
import javax.inject.Inject

interface SearchUserRepositoriesUsecase{
    suspend fun execute (
        user: String,
    ): UserRepositoryEntityResult
}

internal class SearchUserRepositoriesUsecaseImpl @Inject constructor(
    private val repository: UserRepository
): SearchUserRepositoriesUsecase{
    override suspend fun execute(
        user: String,
    ): UserRepositoryEntityResult {
        return repository.getUserRepositories(user)
    }
}