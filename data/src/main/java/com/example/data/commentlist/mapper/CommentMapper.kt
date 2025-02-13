package com.example.data.commentlist.mapper

import com.example.data.commentlist.CommentModelDTO
import com.example.domain.commentlist.CommentModel


fun CommentModelDTO.mapToComment(): CommentModel {
    return CommentModel(
        postId = this.postId ?: -1,
        name = this.name ?: "",
        comment = this.comment ?: ""
    )
}