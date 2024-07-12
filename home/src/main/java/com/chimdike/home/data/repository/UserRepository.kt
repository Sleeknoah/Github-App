package com.chimdike.home.data.repository

import android.util.Log
import com.chimdike.home.data.mapper.RepositoryDtoEntityMapper
import com.chimdike.home.data.mapper.UserDtoEntityMapper
import com.chimdike.home.data.mapper.UserInfoDtoEntityMapper
import com.chimdike.home.data.mapper.UserRepositoryDtoEntityMapper
import com.chimdike.home.data.source.remote.RepositoryDataSource
import com.chimdike.home.data.source.remote.UserDataSource
import com.chimdike.home.domain.entity.RepositoryEntityResult
import com.chimdike.home.domain.entity.UserEntityResult
import com.chimdike.home.domain.entity.UserInfoResult
import com.chimdike.home.domain.entity.UserRepositoryEntityResult
import com.chimdike.home.domain.repository.UserRepository
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource,
    private val repositoryDataSource: RepositoryDataSource,
    private val userDtoEntityMapper: UserDtoEntityMapper,
    private val repositoryDtoEntityMapper: RepositoryDtoEntityMapper,
    private val userRepositoryDtoEntityMapper: UserInfoDtoEntityMapper,
    private val userInfoDtoEntityMapper: UserRepositoryDtoEntityMapper,
): UserRepository {
    override suspend fun getUsers(user: String): UserEntityResult {
        return try {
            dataSource.getUsers(
                user
            ).let {
                userDtoEntityMapper.map(it)
            }
        } catch (e: Exception){
            e.localizedMessage?.let { Log.e("Error", it) }
            userDtoEntityMapper.map(e)
        }
    }

    override suspend fun getRepositories(query: String): RepositoryEntityResult {
        return try {
            repositoryDataSource.getRepositories(query).let {
                repositoryDtoEntityMapper.map(it)
            }
        }catch (e: Exception){
            e.localizedMessage?.let { Log.e("Error", it) }
            repositoryDtoEntityMapper.map(e)
        }
    }

    override suspend fun getUserInfo(user: String): UserInfoResult {
        return try {
            dataSource.getUser(
                user
            ).let {
                userRepositoryDtoEntityMapper.map(it)
            }
        } catch (e: Exception){
            e.localizedMessage?.let { Log.e("Error", it) }
            userRepositoryDtoEntityMapper.map(e)
        }
    }

    override suspend fun getUserRepositories(user: String): UserRepositoryEntityResult {
        return try {
            repositoryDataSource.getUserRepositories(
                user
            ).let {
                userInfoDtoEntityMapper.map(it)
            }
        } catch (e: Exception){
            e.localizedMessage?.let { Log.e("Error", it) }
            userInfoDtoEntityMapper.map(e)
        }
    }
}