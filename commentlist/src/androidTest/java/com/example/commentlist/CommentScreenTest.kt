package com.example.commentlist

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertHasNoClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToNode
import com.example.commentlist.ui.CommentsScreen
import com.example.commentlist.utils.listCommentLoaderTag
import com.example.commentlist.utils.listCommentTag
import com.example.commentlist.viewmodel.CommentUIState
import com.example.coreandroid.theme.CleanWithComposeTheme
import com.example.domain.commentlist.CommentModel
import org.junit.Rule
import org.junit.Test

class CommentScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val onItemClick: (item: CommentModel) -> Unit = {}

    @Test
    fun testPostIdDisplayMatchOrNot() {
        composeTestRule.setContent {
            CleanWithComposeTheme {
                val listState =
                    CommentUIState.SUCCESS(
                        listOf(
                            CommentModel(
                                postId = 11,
                                name = "display1",
                                comment = "hi this is testinggm sajdljsldjaslkfdjlkasjdrflkjefkjdjsjkndfkjansdf,"
                            ),
                            CommentModel(
                                postId = 12,
                                name = "Display2",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 1276,
                                name = "Display33242",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 1255,
                                name = "Displayw42",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 1233,
                                name = "Displaya2",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 121,
                                name = "Display2ahf",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 123,
                                name = "Display2ahka",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 121692,
                                name = "Display2ljsfka",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 123222,
                                name = "Display2kjahsd",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 123322,
                                name = "Display2ewwew",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 122,
                                name = "Display22332",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                        )
                    )
                CommentsScreen(
                    commentsList = listState,
                    onItemClick = onItemClick
                )
            }
        }
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag(listCommentTag)
            .performScrollToNode(hasText("post Id: 1233"))
            .assertHasNoClickAction()

        composeTestRule.onNodeWithTag(listCommentTag)
            .performScrollToNode(hasText("post Id: 11"))
            .assertIsDisplayed()
    }

    @Test
    fun testCommentDisplayMatchOrNot() {
        composeTestRule.setContent {
            MaterialTheme {
                val listState =
                    CommentUIState.SUCCESS(
                        listOf(
                            CommentModel(
                                postId = 11,
                                name = "display1",
                                comment = "hi this is testinggm sajdljsldjaslkfdjlkasjdrflkjefkjdjsjkndfkjansdf,"
                            ),
                            CommentModel(
                                postId = 12,
                                name = "Display2",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 1276,
                                name = "Display33242",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 1255,
                                name = "Displayw42",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 1233,
                                name = "Displaya2",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 121,
                                name = "Display2ahf",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 123,
                                name = "Display2ahka",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 121692,
                                name = "Display2ljsfka",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 123222,
                                name = "Display2kjahsd",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 123322,
                                name = "Display2ewwew",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 122,
                                name = "Display22332",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                        )
                    )
                CommentsScreen(
                    commentsList = listState,
                    onItemClick = onItemClick
                )
            }
        }
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag(listCommentTag)
            .performScrollToNode(hasText("jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"))
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(listCommentTag)
            .performScrollToNode(hasText("jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"))
            .assertExists()
    }

    @Test
    fun testNameDisplayMatchOrNot() {
        composeTestRule.setContent {
            MaterialTheme {
                val listState =
                    CommentUIState.SUCCESS(
                        listOf(
                            CommentModel(
                                postId = 11,
                                name = "display1",
                                comment = "hi this is testinggm sajdljsldjaslkfdjlkasjdrflkjefkjdjsjkndfkjansdf,"
                            ),
                            CommentModel(
                                postId = 12,
                                name = "Display2",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 1276,
                                name = "Display33242",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 1255,
                                name = "Displayw42",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 1233,
                                name = "Displaya2",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 121,
                                name = "Display2ahf",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 123,
                                name = "Display2ahka",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 121692,
                                name = "Display2ljsfka",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 123222,
                                name = "Display2kjahsd",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 123322,
                                name = "Display2ewwew",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                            CommentModel(
                                postId = 122,
                                name = "Display22332",
                                comment = "jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"
                            ),
                        )
                    )
                CommentsScreen(
                    commentsList = listState,
                    onItemClick = onItemClick
                )
            }
        }
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag(listCommentTag)
            .performScrollToNode(hasText("Name: Display2"))
            .assertIsDisplayed()
    }

    @Test
    fun testCommentListDisplayProgress() {
        composeTestRule.setContent {
            MaterialTheme {
                val listState =
                    CommentUIState.LOADING
                CommentsScreen(
                    commentsList = listState,
                    onItemClick = onItemClick
                )
            }
        }
        composeTestRule.onNodeWithTag(listCommentLoaderTag)
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(listCommentLoaderTag)
            .assertHasNoClickAction()
        composeTestRule.onNodeWithTag(listCommentLoaderTag)
            .assertExists()
    }
}