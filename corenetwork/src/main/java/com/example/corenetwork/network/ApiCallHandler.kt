package com.example.corenetwork.network

import okio.IOException
import retrofit2.HttpException

object ApiCallHandler {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): ResultWrapper<T> {
        return try {
            val result = apiCall.invoke()
            ResultWrapper.Success(result)
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException ->
                    ResultWrapper.Failure(throwable.message ?: "IO Error")

                is HttpException ->
                    ResultWrapper.Failure(throwable.message ?: "Http Error")

                else ->
                    ResultWrapper.Failure(throwable.message ?: "Unknown Error")

            }


        }
    }
}