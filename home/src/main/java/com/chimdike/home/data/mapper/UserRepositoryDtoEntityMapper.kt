package com.chimdike.home.data.mapper


import com.chimdike.home.data.dto.RepositoryItemDto
import com.chimdike.home.domain.entity.UserRepositoryEntityResult
import com.chimdike.home.domain.entity.UserRepositoryItemResult
import javax.inject.Inject

internal interface UserRepositoryDtoEntityMapper{
    fun map(dto: List<RepositoryItemDto>): UserRepositoryEntityResult
    fun map(exception: Exception): UserRepositoryEntityResult
}

class UserRepositoryDtoEntityMapperImpl @Inject constructor(): UserRepositoryDtoEntityMapper {
    override fun map(dto: List<RepositoryItemDto>): UserRepositoryEntityResult {
        val result = dto.map { repo ->

            UserRepositoryItemResult(
                description=repo.description,
                fullName=repo.fullName,
                language=repo.language,
                name=repo.name,
                stargazersCount = repo.stargazersCount ?: 0,
                topics = repo.topics ?: emptyList(),
                visibility=repo.visibility,
            )
        }
        return  UserRepositoryEntityResult.Success(result)
    }

    override fun map(exception: Exception): UserRepositoryEntityResult {
        return UserRepositoryEntityResult.Failure(
            message = exception.message ?: "Oops an error just occurred. Please try again"
        )
    }


}