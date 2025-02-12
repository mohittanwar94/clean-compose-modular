package com.example.cleanwithcompose

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.test.assertHasNoClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToNode
import com.example.cleanwithcompose.domain.CommentModel
import com.example.cleanwithcompose.persentor.CommentUIState
import com.example.cleanwithcompose.persentor.CommentsScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.junit.Rule
import org.junit.Test

class CommentScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun testPostIdDisplayMatchOrNot() {
        composeTestRule.setContent {
            MaterialTheme {
                val listState = MutableStateFlow(
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
                ).asStateFlow().collectAsState()
                CommentsScreen(
                    comments = listState
                )
            }
        }
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("commentList")
            .performScrollToNode(hasText("post Id: 1233"))
            .assertHasNoClickAction()

        composeTestRule.onNodeWithTag("commentList")
            .performScrollToNode(hasText("post Id: 11"))
            .assertIsDisplayed()
    }

    @Test
    fun testCommentDisplayMatchOrNot() {
        composeTestRule.setContent {
            MaterialTheme {
                val listState = MutableStateFlow(
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
                ).asStateFlow().collectAsState()
                CommentsScreen(
                    comments = listState
                )
            }
        }
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("commentList")
            .performScrollToNode(hasText("jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"))
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag("commentList")
            .performScrollToNode(hasText("jdfoijrkernfs,dmmsdlkjfoiwejwrioewjioEJQLKMWREKLDSMDLKAMLKDJOIJERFIOEHFUINXCZJKNADKLNKJBHJSBJH"))
            .assertExists()
    }

    @Test
    fun testNameDisplayMatchOrNot() {
        composeTestRule.setContent {
            MaterialTheme {
                val listState = MutableStateFlow(
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
                ).asStateFlow().collectAsState()
                CommentsScreen(
                    comments = listState
                )
            }
        }
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("commentList")
            .performScrollToNode(hasText("Name: Display2"))
            .assertIsDisplayed()
    }

    @Test
    fun testCommentListDisplayProgress() {
        composeTestRule.setContent {
            MaterialTheme {
                val listState = MutableStateFlow(
                    CommentUIState.LOADING
                ).asStateFlow().collectAsState()
                CommentsScreen(
                    comments = listState
                )
            }
        }
        composeTestRule.onNodeWithTag("centerLoader")
            .assertIsDisplayed()

        composeTestRule.onNodeWithTag("centerLoader")
            .assertHasNoClickAction()

        composeTestRule.onNodeWithTag("centerLoader")
            .assertExists()
    }
}