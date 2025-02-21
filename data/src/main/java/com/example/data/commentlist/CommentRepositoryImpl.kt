package com.example.data.commentlist

import com.example.data.commentlist.mapper.mapToComment
import com.example.domain.commentlist.CommentModel
import com.example.domain.commentlist.CommentRepository
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val commentApi: CommentApi,
) : CommentRepository {
    override suspend fun getComments(): List<CommentModel> {
        val listComments = ArrayList<CommentModel>()
        val list = commentApi.getCommentData()
        if (list.isEmpty().not())
            listComments.addAll(list.map { it.mapToComment() })
        else
            listComments
        return listComments
    }
}
