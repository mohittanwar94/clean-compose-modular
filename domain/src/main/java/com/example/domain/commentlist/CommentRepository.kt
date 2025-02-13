package com.example.domain.commentlist

import com.example.corenetwork.network.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher

interface CommentRepository {
    suspend fun getComments(dispatcher: CoroutineDispatcher): ResultWrapper<List<CommentModel>>
}
