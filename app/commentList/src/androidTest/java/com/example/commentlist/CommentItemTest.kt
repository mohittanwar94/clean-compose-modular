package com.example.commentlist

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.commentlist.ui.CommentItem
import com.example.commentlist.utils.listCommentItemCommentTag
import com.example.commentlist.utils.listCommentItemNameTag
import com.example.commentlist.utils.listCommentItemPostIDTag
import com.example.domain.commentlist.CommentModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

const val commentId = 1111
const val name = "testing 1233"
const val comment =
    "this is testing beer item \n testijkdnfknsafknkjdfnjndsaknfknasnkjfdndkjnfdkjnjdfa"

class CommentItemTest {

    @get:Rule
    val composeRule = createComposeRule()


    @Before
    fun setUp() {
        composeRule.setContent {
            CommentItem(
                CommentModel(
                    postId = commentId,
                    name = name,
                    comment = comment,
                ), Modifier.fillMaxWidth()
            )
        }
    }

    @Test
    fun checkCommentExistOrNot() {
        composeRule.waitForIdle()
        composeRule.onNodeWithTag(listCommentItemCommentTag).assertExists()
        composeRule.onNodeWithText(comment).assertExists()
    }

    @Test
    fun checkNameExistOrNot() {
        composeRule.waitForIdle()
        composeRule.onNodeWithTag(listCommentItemNameTag).assertExists()
        composeRule.onNodeWithTag(
            listCommentItemNameTag
        ).isDisplayed()
        composeRule.onNodeWithText(
            "Name: $name"
        ).isDisplayed()
        composeRule.onNodeWithText(
            "Name: $name"
        ).assertExists()
    }

    @Test
    fun checkPostExistOrNot() {
        composeRule.waitForIdle()
        composeRule.onNodeWithTag(listCommentItemPostIDTag).assertExists()
        composeRule.onNodeWithText(
            "post Id: $commentId"
        ).assertExists()
        composeRule.onNodeWithText(
            "post Id: $commentId"
        ).isDisplayed()
    }

}