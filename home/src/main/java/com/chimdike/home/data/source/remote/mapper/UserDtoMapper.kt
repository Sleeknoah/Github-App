package com.chimdike.home.data.source.remote.mapper

import com.chimdike.home.data.dto.ItemDto
import com.chimdike.home.data.dto.UserDto
import com.chimdike.home.data.source.api.model.users.UsersResponse
import com.chimdike.home.domain.entity.UserEntityResult
import com.chimdike.home.domain.entity.UserItemResult
import com.chimdike.home.domain.entity.UserResult
import javax.inject.Inject



internal  interface  UserDtoMapper{
    fun map(usersResponse: UsersResponse): UserDto
}

class UserDtoMapperImpl @Inject constructor(): UserDtoMapper {
    override fun map(usersResponse: UsersResponse): UserDto {
        val userList = usersResponse.items.map { user ->
            ItemDto(
                avatarUrl = user.avatar_url,
                id = user.id,
                login = user.login,
                nodeId = user.node_id,
                type = user.type,
                url =  user.url,
            )
        }
        return  UserDto(
            totalCount = usersResponse.total_count,
            incompleteResults = usersResponse.incomplete_results,
            items = userList,
        )
    }

}