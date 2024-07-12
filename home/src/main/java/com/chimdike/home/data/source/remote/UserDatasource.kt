package com.chimdike.home.data.source.remote

import com.chimdike.core.network.Network
import com.chimdike.home.data.dto.UserDto
import com.chimdike.home.data.dto.UserInfoDto
import com.chimdike.home.data.source.api.UserService
import com.chimdike.home.data.source.remote.mapper.UserDtoMapper
import com.chimdike.home.data.source.remote.mapper.UserInfoDtoMapper
import javax.inject.Inject

internal interface UserDataSource {
    suspend fun getUsers(user:String): UserDto
    suspend fun getUser(userName: String): UserInfoDto
}

internal class UserDataSourceImpl @Inject constructor(
    private val service: UserService,
    private val dtoMapper: UserDtoMapper,
    private val userInfoMapper: UserInfoDtoMapper,
    private val network: Network,
): UserDataSource{
    override suspend fun getUsers(user: String): UserDto {
        return network.eitherResponseOrThrow { service.getUsers(user) }.let {
            dtoMapper.map(it)
        }
    }

    override suspend fun getUser(userName: String): UserInfoDto {
        return network.eitherResponseOrThrow { service.getUser(userName) }.let {
            userInfoMapper.map(it)
        }
    }
}