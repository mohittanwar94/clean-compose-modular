package com.example.domain.commentlist

import javax.inject.Inject

class CommentUseCase @Inject constructor(private val repository: CommentRepository) {

    suspend fun invoke(): List<CommentModel> {
        return repository.getComments()
    }
}