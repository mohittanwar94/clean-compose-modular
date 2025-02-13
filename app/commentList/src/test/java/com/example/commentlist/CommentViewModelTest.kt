package com.example.commentlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.commentlist.viewmodel.CommentUIState
import com.example.commentlist.viewmodel.CommentViewModel
import com.example.corenetwork.network.ResultWrapper
import com.example.domain.commentlist.CommentModel
import com.example.domain.commentlist.CommentRepository
import com.example.domain.commentlist.CommentUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

const val Exception_Msg = "exception in call"
const val PostID = 1
const val Name = "mohit"
const val Comment = "test comment"

@RunWith(MockitoJUnitRunner::class)
class CommentViewModelTest {


    @Mock
    private lateinit var repositoryImpl: CommentRepository
    private lateinit var useCase: CommentUseCase

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    private val executor = InstantTaskExecutorRule()


    @get:Rule
    private val testRule = CoroutineTestRule(testDispatcher)


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun checkSuccess() = runTest {
        useCase = CommentUseCase(repositoryImpl)
        val commentModel = CommentModel(PostID, Name, Comment)
        val expectedData =
            ResultWrapper.Success(listOf(commentModel))
        Mockito.`when`(repositoryImpl.getComments(testDispatcher)).thenReturn(expectedData)
        val viewModel = CommentViewModel(useCase, testDispatcher)
        assertTrue(viewModel.commentUIState.first() == CommentUIState.LOADING)
        testDispatcher.scheduler.advanceUntilIdle()
        assertTrue(viewModel.commentUIState.first() is CommentUIState.SUCCESS)
        assertEquals(
            expectedData.data[0].comment,
            (viewModel.commentUIState.first() as CommentUIState.SUCCESS).data[0].comment
        )
    }

    @Test
    fun checkFailureInNetworkCallMsgShouldBeThere() = runTest {
        useCase = CommentUseCase(repositoryImpl)
        val viewModel = CommentViewModel(useCase, testDispatcher)
        val expectedData = ResultWrapper.Failure<Nothing>(Exception_Msg)
        Mockito.`when`(repositoryImpl.getComments(testDispatcher)).thenReturn(expectedData)
        assertTrue(viewModel.commentUIState.first() == CommentUIState.LOADING)
        testDispatcher.scheduler.advanceUntilIdle()
        println("================${viewModel.commentUIState.value}")
        assertTrue(viewModel.commentUIState.first() is CommentUIState.FAILURE)

        assertEquals(
            expectedData.msg,
            (viewModel.commentUIState.first() as CommentUIState.FAILURE).message
        )
    }


    @After
    fun tearDown() {
    }
}