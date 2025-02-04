package com.example.cleanwithcompose.data

import retrofit2.http.GET

interface ApiInterface {

    @GET("/comments/")
    suspend fun getCommentData(): List<CommentModelDTO>
}