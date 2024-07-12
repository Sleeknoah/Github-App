package com.chimdike.home.domain.usecase

import com.chimdike.home.domain.entity.UserEntityResult
import com.chimdike.home.domain.entity.UserInfoResult
import com.chimdike.home.domain.repository.UserRepository
import javax.inject.Inject

interface SearchUserInfoUsecase{
    suspend fun execute (
        user: String,
    ): UserInfoResult
}

internal class SearchUserInfoUsecaseImpl @Inject constructor(
    private val repository: UserRepository
): SearchUserInfoUsecase{
    override suspend fun execute(
        user: String,
    ): UserInfoResult {
        return repository.getUserInfo(
            user = user
        )
    }
}