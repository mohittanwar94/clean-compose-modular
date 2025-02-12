package com.example.commentlist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.commentlist.ui.CommentScreenRoute

const val COMMENT_LIST_NAVIGATION = "commentListScreen"

/*use for comment navigation extension function*/
fun NavController.navigateToCommentList() {
    navigate(COMMENT_LIST_NAVIGATION)
}

/*create Graph entry through NavGraph Builder*/
fun NavGraphBuilder.commentListScreen(onBackClick: () -> Unit) {
    composable(route = COMMENT_LIST_NAVIGATION) {
        CommentScreenRoute(
            onBackClick = onBackClick
        )
    }

}