package com.example.cleanwithcompose.domain

import com.example.cleanwithcompose.data.network.CommentApiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

interface CommentRepository {
    suspend fun getComments(dispatcher: CoroutineDispatcher): Flow<CommentApiState<List<CommentModel>>>
}
