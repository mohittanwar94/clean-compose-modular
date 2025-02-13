package com.example.domain.commentlist

import com.example.corenetwork.network.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class CommentUseCase @Inject constructor(private val repository: CommentRepository) {

    suspend fun invoke(io: CoroutineDispatcher): ResultWrapper<List<CommentModel>> {
        return repository.getComments(
            io
        )
    }
}