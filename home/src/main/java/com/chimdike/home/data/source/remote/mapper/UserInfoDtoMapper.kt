package com.chimdike.home.data.source.remote.mapper

import com.chimdike.home.data.dto.ItemDto
import com.chimdike.home.data.dto.UserDto
import com.chimdike.home.data.dto.UserInfoDto
import com.chimdike.home.data.source.api.model.users.UserInfoResponse
import com.chimdike.home.data.source.api.model.users.UsersResponse
import com.chimdike.home.domain.entity.UserEntityResult
import com.chimdike.home.domain.entity.UserItemResult
import com.chimdike.home.domain.entity.UserResult
import javax.inject.Inject



internal interface UserInfoDtoMapper{
    fun map(response: UserInfoResponse): UserInfoDto
}

class UserInfoDtoMapperImpl @Inject constructor(): UserInfoDtoMapper {
    override fun map(response: UserInfoResponse): UserInfoDto {
        
        return  UserInfoDto(
            avatarUrl= response.avatarUrl ?: "",
            bio= response.bio ?: "",
        email= response.email ?: "",
        followers= response.followers ?: 0,
        following= response.following ?: 0,
        htmlUrl= response.htmlUrl ?: "",
        location= response.location ?: "",
        login= response.login ?: "",
        name= response.name ?: "",
        publicRepos= response.publicRepos ?: 0,
        )
    }

}