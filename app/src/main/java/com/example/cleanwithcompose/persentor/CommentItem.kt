package com.example.cleanwithcompose.persentor

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.cleanwithcompose.domain.CommentModel
import com.example.cleanwithcompose.ui.theme.CleanWithComposeTheme
import com.example.cleanwithcompose.ui.theme.Typography

@Composable
fun CommentItem(
    comment: CommentModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .testTag("card"),
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
                text = "Name: " + comment.name,
                style = Typography.titleLarge,
                modifier = Modifier
                    .testTag("name")
                    .padding(horizontal = 10.dp)
                    .constrainAs(name) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        width = Dimension.wrapContent
                    })
            Text(
                text = "post Id: " + comment.postId,
                style = Typography.titleMedium,
                modifier = Modifier
                    .testTag("postId")
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
                    .testTag("commentText")
                    .padding(horizontal = 10.dp, vertical = 0.dp)
                    .constrainAs(commentText) {
                        start.linkTo(parent.start)
                        top.linkTo(postId.bottom)
                        width = Dimension.wrapContent
                    })
        }
    }
}

@Preview
@Composable
fun BeerItemPreview() {
    CleanWithComposeTheme {
        CommentItem(
            comment = CommentModel(
                name = "Test Comment",
                comment = "this is a very good comment \nchecking comment quality through tasting it jhfjhfjhjj hghgjhgjhgjhgjhftyrtdgfdhgjhhkjhhjhhghfghfgdfgdghgghghfg jflksjdfkljfjsdh",
                postId = 12232,
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}