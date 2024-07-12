package com.chimdike.home.domain.usecase

import com.chimdike.home.domain.entity.UserEntityResult
import com.chimdike.home.domain.repository.UserRepository
import javax.inject.Inject

interface SearchUserUsecase{
    suspend fun execute (
        user: String,
    ): UserEntityResult
}

internal class SearchUserUsecaseImpl @Inject constructor(
    private val repository: UserRepository
): SearchUserUsecase{
    override suspend fun execute(
        user: String,
    ): UserEntityResult {
        return repository.getUsers(
            user = user
        )
    }
}