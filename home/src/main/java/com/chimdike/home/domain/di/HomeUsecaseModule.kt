package com.chimdike.home.domain.di

import com.chimdike.home.domain.usecase.SearchRepositoriesUsecase
import com.chimdike.home.domain.usecase.SearchRepositoriesUsecaseImpl
import com.chimdike.home.domain.usecase.SearchUserInfoUsecase
import com.chimdike.home.domain.usecase.SearchUserInfoUsecaseImpl
import com.chimdike.home.domain.usecase.SearchUserRepositoriesUsecase
import com.chimdike.home.domain.usecase.SearchUserRepositoriesUsecaseImpl
import com.chimdike.home.domain.usecase.SearchUserUsecase
import com.chimdike.home.domain.usecase.SearchUserUsecaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
internal interface HomeUsecaseModule {

    @Binds
    fun bindSearchUserUsecase(impl: SearchUserUsecaseImpl): SearchUserUsecase


    @Binds
    fun bindSearchRepositoriesUsecase(impl: SearchRepositoriesUsecaseImpl): SearchRepositoriesUsecase

    @Binds
    fun bindSearchUserRepositoriesUsecase(impl: SearchUserRepositoriesUsecaseImpl): SearchUserRepositoriesUsecase

    @Binds
    fun bindSearchUserInfoUsecase(impl: SearchUserInfoUsecaseImpl): SearchUserInfoUsecase

}
