package com.chimdike.home.data.source.api.model.users

import com.chimdike.home.data.source.api.model.users.Item

data class UsersResponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)