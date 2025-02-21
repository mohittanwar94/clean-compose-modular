package com.example.profile.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.cleanwithcompose.R
import com.example.coreandroid.theme.Typography
import com.example.profile.utils.BACK_PRESS
import com.example.profile.utils.Comment
import com.example.profile.utils.NAME


@Composable
fun ProfileScreenRoute(postId: String?, name: String?, comment: String?, onBackClick: () -> Unit) {
    ProfileScreen(onBackClick, postId, name, comment)
}

@Preview(widthDp = 420, heightDp = 800)
@Composable
fun ProfileScreenPreview() {
    val backClick: () -> Unit = {}
    ProfileScreen(onBackClick = backClick, postId = "1233", name = "test", comment = "comment")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(onBackClick: () -> Unit, postId: String?, name: String?, comment: String?) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.profile),
                    color = Color.White
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.White,
            ),
            navigationIcon = {
                IconButton(onClick = {
                    onBackClick.invoke()
                }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = BACK_PRESS,
                        tint = Color.White
                    )
                }
            }
        )
    }) { contentPadding ->
        Card(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(contentPadding)
                .padding(30.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.elevatedCardElevation(4.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(all = 15.dp)
            ) {
                val (nameText, commentText) = createRefs()

                Text(
                    modifier = Modifier
                        .testTag(NAME)
                        .constrainAs(nameText) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.wrapContent
                            height = Dimension.wrapContent
                        },
                    textAlign = TextAlign.Justify,
                    text = name ?: "",
                    style = Typography.titleLarge
                )

                Text(
                    modifier = Modifier.padding(top = 30.dp)
                        .testTag(Comment)
                        .constrainAs(commentText) {
                            top.linkTo(nameText.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.wrapContent
                            height = Dimension.wrapContent
                        },
                    textAlign = TextAlign.Justify,
                    text = comment ?: "",
                    style = Typography.titleMedium
                )
            }

        }

    }

}