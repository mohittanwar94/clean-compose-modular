package com.example.cleanwithcompose.domain

import com.example.cleanwithcompose.data.network.CommentApiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class CommentUseCase @Inject constructor(private val respository: CommentRepository) {

    suspend fun invoke(io: CoroutineDispatcher):Flow<CommentApiState<List<CommentModel>>> {
       return respository.getComments(
            io
        )
    }
}