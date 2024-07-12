package com.chimdike.home.data.source.remote.mapper

import com.chimdike.home.data.dto.ItemDto
import com.chimdike.home.data.dto.OwnerDto
import com.chimdike.home.data.dto.RepositoryDto
import com.chimdike.home.data.dto.RepositoryItemDto
import com.chimdike.home.data.dto.UserDto
import com.chimdike.home.data.source.api.model.repositories.RepositoryResponse
import com.chimdike.home.data.source.api.model.users.UsersResponse
import com.chimdike.home.domain.entity.UserEntityResult
import com.chimdike.home.domain.entity.UserItemResult
import com.chimdike.home.domain.entity.UserResult
import javax.inject.Inject



internal  interface  RepositoryDtoMapper{
    fun map(response: RepositoryResponse): RepositoryDto
}

class RepositoryDtoMapperImpl @Inject constructor(): RepositoryDtoMapper {
    override fun map(response: RepositoryResponse): RepositoryDto {
         val repoList = response.items.map { repo ->

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
        return  RepositoryDto(
            totalCount = response.totalCount,
            incompleteResults = response.incompleteResults,
            items = repoList,
        )
    }

}