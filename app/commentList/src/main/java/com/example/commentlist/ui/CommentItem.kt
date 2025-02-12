package com.example.commentlist.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.cleanwithcompose.R
import com.example.commentlist.utils.listCommentItemCardTag
import com.example.commentlist.utils.listCommentItemCommentTag
import com.example.commentlist.utils.listCommentItemNameTag
import com.example.commentlist.utils.listCommentItemPostIDTag
import com.example.coreandroid.theme.Typography
import com.example.domain.CommentModel

@Composable
fun CommentItem(
    comment: CommentModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .testTag(listCommentItemCardTag),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            val (name, commentText, postId) = createRefs()
            Text(
                text = stringResource(R.string.name) + comment.name,
                style = Typography.titleLarge,
                modifier = Modifier
                    .testTag(listCommentItemNameTag)
                    .padding(horizontal = 10.dp)
                    .constrainAs(name) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        width = Dimension.wrapContent
                    })
            Text(
                text = stringResource(R.string.post_id) + comment.postId,
                style = Typography.titleMedium,
                modifier = Modifier
                    .testTag(listCommentItemPostIDTag)
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .constrainAs(postId) {
                        start.linkTo(parent.start)
                        top.linkTo(name.bottom)
                        width = Dimension.wrapContent
                    })
            Text(
                text = comment.comment,
                style = Typography.titleSmall,
                modifier = Modifier
                    .testTag(listCommentItemCommentTag)
                    .padding(horizontal = 10.dp, vertical = 0.dp)
                    .constrainAs(commentText) {
                        start.linkTo(parent.start)
                        top.linkTo(postId.bottom)
                        width = Dimension.wrapContent
                    })
        }
    }
}