package com.example.cleanwithcompose.data.mapper

import com.example.cleanwithcompose.data.CommentModelDTO
import com.example.cleanwithcompose.domain.CommentModel

fun CommentModelDTO.mapToComment(): CommentModel {
    return CommentModel(
        postId = this.postId ?: -1,
        name = this.name ?: "",
        comment = this.comment ?: ""
    )
}