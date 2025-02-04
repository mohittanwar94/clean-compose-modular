package com.example.cleanwithcompose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.cleanwithcompose.domain.CommentModel
import com.example.cleanwithcompose.persentor.CommentItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CommentItemTest {

    @get:Rule
    val composeRule = createComposeRule()


    @Before
    fun setUp(){
        composeRule.setContent {
            CommentItem(
                CommentModel(
                    postId = 1111,
                    name = "testing 1233",
                    comment = "this is testing beer item \n testijkdnfknsafknkjdfnjndsaknfknasnkjfdndkjnfdkjnjdfa",
                ), Modifier.fillMaxWidth()
            )
        }
    }
    @Test
    fun checkCommentExistOrNot() {
        composeRule.waitForIdle()
        composeRule.onNodeWithTag("commentText").assertExists()
        composeRule.onNodeWithText("this is testing beer item \n" +
                " testijkdnfknsafknkjdfnjndsaknfknasnkjfdndkjnfdkjnjdfa").assertExists()
    }

    @Test
    fun checkNameExistOrNot() {
        composeRule.waitForIdle()
        composeRule.onNodeWithTag("name").assertExists()
        composeRule.onNodeWithTag(
            "name"
        ).isDisplayed()
        composeRule.onNodeWithText(
            "Name: testing 1233"
        ).isDisplayed()
        composeRule.onNodeWithText(
            "Name: testing 1233"
        ).assertExists()
    }

    @Test
    fun checkPostExistOrNot() {
        composeRule.waitForIdle()
        composeRule.onNodeWithTag("postId").assertExists()
        composeRule.onNodeWithText(
            "post Id: 1111"
        ).assertExists()
        composeRule.onNodeWithText(
            "post Id: 1111"
        ).isDisplayed()
    }

}