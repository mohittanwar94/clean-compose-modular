package com.example.data

import com.example.corenetwork.network.CommentApiState
import com.example.data.mapper.mapToComment
import com.example.domain.CommentModel
import com.example.domain.CommentRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val commentApi: CommentApi,
) : CommentRepository {
    override suspend fun getComments(dispatcher: CoroutineDispatcher): Flow<CommentApiState<List<CommentModel>>> {
        return flow {
            val comments = commentApi.getCommentData()
            val commentList = comments.map { comment ->
                comment.mapToComment()
            }
            emit(CommentApiState.success(commentList))
        }.flowOn(dispatcher)
    }
}