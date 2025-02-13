package com.example.corenetwork.network

sealed class ResultWrapper<out T> {
    data class Success<out T>(val data: T) : ResultWrapper<T>()
    data class Failure<Nothing>(val msg: String) : ResultWrapper<Nothing>()
}