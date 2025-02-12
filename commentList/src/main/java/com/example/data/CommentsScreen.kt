package com.example.data

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp


@Composable
fun CommentsScreen(comments: State<CommentUIState>) {
    val context = LocalContext.current
    Scaffold { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(contentPadding)
        ) {
            when (comments.value) {
                is CommentUIState.LOADING -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .testTag("centerLoader")
                            .size(30.dp)
                            .align(Alignment.Center)
                    )
                }

                is CommentUIState.FAILURE -> {
                    Toast.makeText(
                        context,
                        (comments.value as CommentUIState.FAILURE).message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is CommentUIState.SUCCESS -> {
                    val commentList = (comments.value as CommentUIState.SUCCESS).data
                    LazyColumn(
                        modifier = Modifier.fillMaxSize().testTag("commentList"),
                        verticalArrangement = Arrangement.spacedBy(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        contentPadding = PaddingValues(start = 10.dp, end = 10.dp)
                    ) {
                        items(commentList.size) { commentIndex ->
                            CommentItem(commentList[commentIndex], Modifier.fillMaxWidth())
                        }
                    }
                }
            }
        }
    }
}