package com.chimdike.core.network

import com.squareup.moshi.Json

data class ErrorResponse(
    @Json(name = "message") val message: String
)