package com.chimdike.home.data.source.remote

import com.chimdike.core.network.Network
import com.chimdike.home.data.dto.RepositoryDto
import com.chimdike.home.data.dto.RepositoryItemDto
import com.chimdike.home.data.source.api.UserService
import com.chimdike.home.data.source.remote.mapper.RepositoryDtoMapper
import com.chimdike.home.data.source.remote.mapper.UserRepositoryDtoMapper
import javax.inject.Inject

internal interface RepositoryDataSource {
    suspend fun getRepositories(query: String): RepositoryDto
    suspend fun getUserRepositories(user: String): List<RepositoryItemDto>
}

internal class RepositoryDataSourceImpl @Inject constructor(
    private val service: UserService,
    private val dtoMapper: RepositoryDtoMapper,
    private val repositoryDtoMapper: UserRepositoryDtoMapper,
    private val network: Network,
): RepositoryDataSource{
    override suspend fun getRepositories(query: String): RepositoryDto {
        return network.eitherResponseOrThrow { service.getRepositories(query) }.let {
            dtoMapper.map(it)
        }
    }

    override suspend fun getUserRepositories(user: String): List<RepositoryItemDto> {
        return network.eitherResponseOrThrow { service.getUserRepos(user) }.let {
            repositoryDtoMapper.map(it)
        }
    }
}