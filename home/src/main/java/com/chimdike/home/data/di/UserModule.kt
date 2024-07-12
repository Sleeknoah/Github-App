package com.chimdike.home.data.di

import com.chimdike.home.data.mapper.RepositoryDtoEntityMapper
import com.chimdike.home.data.mapper.RepositoryDtoEntityMapperImpl
import com.chimdike.home.data.mapper.UserDtoEntityMapper
import com.chimdike.home.data.mapper.UserDtoEntityMapperImpl
import com.chimdike.home.data.mapper.UserInfoDtoEntityMapper
import com.chimdike.home.data.mapper.UserInfoDtoEntityMapperImpl
import com.chimdike.home.data.mapper.UserRepositoryDtoEntityMapper
import com.chimdike.home.data.mapper.UserRepositoryDtoEntityMapperImpl
import com.chimdike.home.data.repository.UserRepositoryImpl
import com.chimdike.home.data.source.api.UserService
import com.chimdike.home.data.source.remote.RepositoryDataSource
import com.chimdike.home.data.source.remote.RepositoryDataSourceImpl
import com.chimdike.home.data.source.remote.UserDataSource
import com.chimdike.home.data.source.remote.UserDataSourceImpl
import com.chimdike.home.data.source.remote.mapper.RepositoryDtoMapper
import com.chimdike.home.data.source.remote.mapper.RepositoryDtoMapperImpl
import com.chimdike.home.data.source.remote.mapper.UserDtoMapper
import com.chimdike.home.data.source.remote.mapper.UserDtoMapperImpl
import com.chimdike.home.data.source.remote.mapper.UserInfoDtoMapper
import com.chimdike.home.data.source.remote.mapper.UserInfoDtoMapperImpl
import com.chimdike.home.data.source.remote.mapper.UserRepositoryDtoMapper
import com.chimdike.home.data.source.remote.mapper.UserRepositoryDtoMapperImpl
import com.chimdike.home.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal interface UserModule {
    @Binds
    fun bindUserDtoMapper(impl: UserDtoMapperImpl): UserDtoMapper

    @Binds
    fun bindRepoDtoMapper(impl: RepositoryDtoMapperImpl): RepositoryDtoMapper

    @Binds
    fun bindUserRepoInfoDtoMapper(impl: UserRepositoryDtoMapperImpl): UserRepositoryDtoMapper

    @Binds
    fun bindUserInfoDtoMapper(impl: UserInfoDtoMapperImpl): UserInfoDtoMapper

    @Binds
    fun bindUserDataSource(impl: UserDataSourceImpl):UserDataSource

    @Binds
    fun bindRepoDataSource(impl: RepositoryDataSourceImpl):RepositoryDataSource

    @Binds
    fun bindUserDtoEntityMapper(impl: UserDtoEntityMapperImpl): UserDtoEntityMapper

    @Binds
    fun bindRepoDtoEntityMapper(impl: RepositoryDtoEntityMapperImpl): RepositoryDtoEntityMapper

    @Binds
    fun bindUserInfoDtoEntityMapper(impl: UserInfoDtoEntityMapperImpl): UserInfoDtoEntityMapper

    @Binds
    fun bindUserReposInfoDtoEntityMapper(impl: UserRepositoryDtoEntityMapperImpl): UserRepositoryDtoEntityMapper

    @Binds
    fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository


    companion object{
        @Provides
        fun provideService(retrofit: Retrofit): UserService {
            return retrofit.create(UserService::class.java)
        }
    }
}