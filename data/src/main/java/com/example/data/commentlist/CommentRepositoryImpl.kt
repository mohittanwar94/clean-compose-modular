package com.example.data.commentlist

import com.example.corenetwork.network.ApiCallHandler.safeApiCall
import com.example.corenetwork.network.ResultWrapper
import com.example.data.commentlist.mapper.mapToComment
import com.example.domain.commentlist.CommentModel
import com.example.domain.commentlist.CommentRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val commentApi: CommentApi,
) : CommentRepository {
    override suspend fun getComments(dispatcher: CoroutineDispatcher): ResultWrapper<List<CommentModel>> {
        val dataResult = safeApiCall(dispatcher) { commentApi.getCommentData() }
        return when (dataResult) {
            is ResultWrapper.Success -> {
                val commentList = dataResult.data.map { it.mapToComment() }
                ResultWrapper.Success(commentList)
            }

            is ResultWrapper.Failure -> ResultWrapper.Failure(dataResult.msg)
        }
    }
}
