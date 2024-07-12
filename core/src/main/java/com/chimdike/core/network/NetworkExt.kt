package com.chimdike.core.network

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody
import okio.IOException
import retrofit2.Response
import java.net.SocketException
import javax.inject.Inject
import javax.net.ssl.SSLHandshakeException

interface Network {
    suspend fun<T> eitherResponseOrThrow(networkCall: suspend () -> Response<T>): T
}

class NetworkExt @Inject constructor(
    private val connectionChecker: ConnectionChecker
): Network{
    override suspend fun<T> eitherResponseOrThrow(networkCall: suspend () -> Response<T>): T{
        if(!connectionChecker.isConnected()) throw AppException("No internet connection")
        try {
            val response  = networkCall.invoke()
            if(response.isSuccessful){
                return response.body()!!
            }else{
                val status = response.code()
                if(status == 404){
                    throw AppException("Oops... Looks like you missed your way")
                }
                if(status == 500){
                    throw AppException("Oops... We've hit a snag. Our engineers will are fixing this")
                }
                val message = response.errorBody()?.extractErrorMessage()
                    ?: "Request failed. Please try again later"
                throw AppException(message)
            }
        }catch (e: Exception){
            when(e) {
                is SocketException -> {
                   throw AppException("Please check your internet connection")
                }
                is IOException -> {
                    throw AppException("Please check your internet connection")
                }
                else -> throw AppException("Oops... We've hit a snag. Our engineers will are fixing this")
            }

        }
    }
}


@Throws
fun ResponseBody.extractErrorMessage(): String? {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val jsonAdapter: JsonAdapter<ErrorResponse> = moshi.adapter(ErrorResponse::class.java)
    val errorResponse = jsonAdapter.fromJson(this.string())
    return errorResponse?.message
}