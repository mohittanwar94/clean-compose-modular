package com.example.domain.commentlist

interface CommentRepository {
    suspend fun getComments(): List<CommentModel>
}
