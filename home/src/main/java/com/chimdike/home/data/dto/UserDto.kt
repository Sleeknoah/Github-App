package com.chimdike.home.data.dto

data class UserDto(
    val incompleteResults: Boolean,
    val items: List<ItemDto>,
    val totalCount: Int
)

data class ItemDto(
    val avatarUrl: String,
    val id: Int,
    val login: String,
    val nodeId: String,
    val type: String,
    val url: String
)
