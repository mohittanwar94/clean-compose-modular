package com.example.data

import retrofit2.http.GET

interface CommentApi {

    @GET("/comments/")
    suspend fun getCommentData(): List<CommentModelDTO>
}