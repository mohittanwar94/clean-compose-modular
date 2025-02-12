package com.example.commentlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coreandroid.theme.CleanWithComposeTheme
import com.example.commentlist.ui.CommentsScreen
import com.example.commentlist.viewmodel.CommentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CleanWithComposeTheme {
                val viewModelComment = hiltViewModel<CommentViewModel>()
                val uiState = viewModelComment.commentUIState.collectAsState()
                CommentsScreen(uiState)
            }
        }
    }
}