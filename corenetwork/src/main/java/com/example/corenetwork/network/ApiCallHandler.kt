package com.example.corenetwork.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException

object ApiCallHandler {
    suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher,
        apiCall: suspend () -> T
    ): ResultWrapper<T> {
        return withContext(dispatcher) {
            try {
                val result = apiCall.invoke()
                ResultWrapper.Success(result)
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException ->
                        ResultWrapper.Failure(throwable.message ?: "Unknown Error")

                    is HttpException ->
                        ResultWrapper.Failure(throwable.message ?: "Unknown Error")

                    else ->
                        ResultWrapper.Failure(throwable.message ?: "Unknown Error")

                }

            }
        }
    }
}