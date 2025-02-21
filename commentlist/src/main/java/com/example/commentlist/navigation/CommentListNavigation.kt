package com.example.commentlist.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.commentlist.ui.CommentScreenRoute
import com.example.domain.commentlist.CommentModel

const val COMMENT_LIST_NAVIGATION = "commentListScreen"

/*use for comment navigation extension function*/
fun NavController.navigateToCommentList() {
    navigate(COMMENT_LIST_NAVIGATION)
}

/*create Graph entry through NavGraph Builder*/
fun NavGraphBuilder.commentListScreen(onItemClick: (item:CommentModel) -> Unit) {
    composable(route = COMMENT_LIST_NAVIGATION) {
        CommentScreenRoute(
            onItemClick = onItemClick
        )
    }

}