package com.chimdike.home.domain.repository

import com.chimdike.home.domain.entity.RepositoryEntityResult
import com.chimdike.home.domain.entity.UserEntityResult
import com.chimdike.home.domain.entity.UserInfoResult
import com.chimdike.home.domain.entity.UserRepositoryEntityResult

interface UserRepository{
    suspend fun getUsers(user: String): UserEntityResult
    suspend fun getRepositories(query: String): RepositoryEntityResult
    suspend fun getUserInfo(user: String): UserInfoResult
    suspend fun getUserRepositories(user: String): UserRepositoryEntityResult
}