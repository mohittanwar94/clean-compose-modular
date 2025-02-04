package com.example.cleanwithcompose.data

import com.example.cleanwithcompose.data.mapper.mapToComment
import com.example.cleanwithcompose.data.network.CommentApiState
import com.example.cleanwithcompose.domain.CommentModel
import com.example.cleanwithcompose.domain.CommentRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface,
) : CommentRepository {
    override suspend fun getComments(dispatcher: CoroutineDispatcher): Flow<CommentApiState<List<CommentModel>>> {
        return flow {
            val comments = apiInterface.getCommentData()
            val commentList = comments.map { comment ->
                comment.mapToComment()
            }
            emit(CommentApiState.success(commentList))
        }.flowOn(dispatcher)
    }
}