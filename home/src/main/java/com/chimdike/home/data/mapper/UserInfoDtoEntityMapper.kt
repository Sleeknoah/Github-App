package com.chimdike.home.data.mapper


import com.chimdike.home.data.dto.UserDto
import com.chimdike.home.data.dto.UserInfoDto
import com.chimdike.home.domain.entity.UserEntityResult
import com.chimdike.home.domain.entity.UserInfoEntity
import com.chimdike.home.domain.entity.UserInfoResult
import com.chimdike.home.domain.entity.UserItemResult
import com.chimdike.home.domain.entity.UserResult
import javax.inject.Inject

internal  interface  UserInfoDtoEntityMapper{
    fun map(dto: UserInfoDto): UserInfoResult
    fun map(exception: Exception): UserInfoResult
}

class UserInfoDtoEntityMapperImpl @Inject constructor(): UserInfoDtoEntityMapper {
    override fun map(dto: UserInfoDto): UserInfoResult {

        val userResult =  UserInfoEntity(
            avatarUrl= dto.avatarUrl,
            bio= dto.bio,
            email= dto.email,
            followers= dto.followers,
            following= dto.following,
            htmlUrl= dto.htmlUrl,
            location= dto.location,
            login= dto.login,
            name= dto.name,
            publicRepos= dto.publicRepos,
        )
        return  UserInfoResult.Success(
            userResult
        )
    }

    override fun map(exception: Exception): UserInfoResult {
        return UserInfoResult.Failure(
            message = exception.message ?: "Oops an error just occurred. Please try again"
        )
    }


}