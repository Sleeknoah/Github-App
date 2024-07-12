package com.chimdike.home.data.source.remote.mapper

import com.chimdike.home.data.dto.ItemDto
import com.chimdike.home.data.dto.OwnerDto
import com.chimdike.home.data.dto.RepositoryDto
import com.chimdike.home.data.dto.RepositoryItemDto
import com.chimdike.home.data.dto.UserDto
import com.chimdike.home.data.source.api.model.repositories.Item
import com.chimdike.home.data.source.api.model.repositories.RepositoryResponse
import com.chimdike.home.data.source.api.model.users.UsersResponse
import com.chimdike.home.domain.entity.UserEntityResult
import com.chimdike.home.domain.entity.UserItemResult
import com.chimdike.home.domain.entity.UserResult
import javax.inject.Inject



internal interface UserRepositoryDtoMapper{
    fun map(response: List<Item>): List<RepositoryItemDto>
}

class UserRepositoryDtoMapperImpl @Inject constructor(): UserRepositoryDtoMapper {
    override fun map(response: List<Item>): List<RepositoryItemDto> {

        val repoList = response.map { repo ->

            val owner = OwnerDto(
                login = repo.owner.login,
                avatarUrl = repo.owner.avatarUrl,
            )

            RepositoryItemDto(
                description=repo.description ?: "",
                fullName=repo.fullName,
                language=repo.language ?: "",
                name=repo.name,
                owner= owner,
                stargazersCount = repo.stargazersCount ?: 0,
                topics = repo.topics ?: emptyList(),
                visibility=repo.visibility,
            )
        }
        return  repoList
    }


}