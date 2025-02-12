package com.example.commentlist.ui

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.commentlist.utils.listCommentLoaderTag
import com.example.commentlist.utils.listCommentTag
import com.example.commentlist.viewmodel.CommentUIState
import com.example.commentlist.viewmodel.CommentViewModel


@Composable
fun CommentScreenRoute(viewModel: CommentViewModel = hiltViewModel(), onBackClick: () -> Unit) {
    val commentListState by viewModel.commentUIState.collectAsStateWithLifecycle()
    CommentsScreen(commentListState)
}

@Composable
fun CommentsScreen(commentsList: CommentUIState) {
    val context = LocalContext.current
    Scaffold { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(contentPadding)
        ) {
            when (commentsList) {
                is CommentUIState.LOADING -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .testTag(listCommentLoaderTag)
                            .size(30.dp)
                            .align(Alignment.Center)
                    )
                }

                is CommentUIState.FAILURE -> {
                    Toast.makeText(
                        context, commentsList.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is CommentUIState.SUCCESS -> {
                    val commentList = commentsList.data
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .testTag(listCommentTag),
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