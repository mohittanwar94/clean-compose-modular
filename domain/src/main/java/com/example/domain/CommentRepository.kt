package com.example.domain

import com.example.corenetwork.network.CommentApiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

interface CommentRepository {
    suspend fun getComments(dispatcher: CoroutineDispatcher): Flow<CommentApiState<List<CommentModel>>>
}
