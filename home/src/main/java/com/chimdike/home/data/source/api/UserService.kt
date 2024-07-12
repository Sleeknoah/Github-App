package com.chimdike.home.data.source.api

import com.chimdike.home.data.source.api.model.repositories.Item
import com.chimdike.home.data.source.api.model.repositories.RepositoryResponse
import com.chimdike.home.data.source.api.model.users.UserInfoResponse
import com.chimdike.home.data.source.api.model.users.UsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {
    @GET("/search/repositories")
    suspend fun getRepositories(@Query("q") query:String): Response<RepositoryResponse>

    @GET("/search/users")
    suspend fun getUsers(@Query("q") query:String): Response<UsersResponse>

    @GET("/users/{login}")
    suspend fun getUser(@Path("login") query:String): Response<UserInfoResponse>

    @GET("/users/{login}/repos")
    suspend fun getUserRepos(@Path("login") query:String): Response<List<Item>>
}