package com.chimdike.home.data.mapper


import com.chimdike.home.data.dto.UserDto
import com.chimdike.home.domain.entity.UserEntityResult
import com.chimdike.home.domain.entity.UserItemResult
import com.chimdike.home.domain.entity.UserResult
import javax.inject.Inject

internal  interface  UserDtoEntityMapper{
    fun map(dto: UserDto): UserEntityResult
    fun map(exception: Exception): UserEntityResult
}

class UserDtoEntityMapperImpl @Inject constructor(): UserDtoEntityMapper {
    override fun map(dto: UserDto): UserEntityResult {
        val users = dto.items.map { user ->
            UserItemResult(
                avatarUrl = user.avatarUrl,
                id = user.id,
                login = user.login,
                nodeId = user.nodeId,
                type = user.type,
                url =  user.url,
            )
        }
        val userResult = UserResult(
            totalCount = dto.totalCount,
            incompleteResults = dto.incompleteResults,
            items = users,
        )
        return  UserEntityResult.UserSuccess(
            userResult
        )
    }

    override fun map(exception: Exception): UserEntityResult {
        return UserEntityResult.UserFailure(
            message = exception.message ?: "Oops an error just occurred. Please try again"
        )
    }


}