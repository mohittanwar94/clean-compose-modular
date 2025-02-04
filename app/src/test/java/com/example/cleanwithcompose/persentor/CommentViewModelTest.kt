package com.example.cleanwithcompose.persentor

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cleanwithcompose.CoroutineTestRule
import com.example.cleanwithcompose.data.network.CommentApiState
import com.example.cleanwithcompose.domain.CommentModel
import com.example.cleanwithcompose.domain.CommentRepository
import com.example.cleanwithcompose.domain.CommentUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
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

@OptIn(ExperimentalCoroutinesApi::class)
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
        val viewModel = CommentViewModel(useCase, testDispatcher)
        val commentModel = CommentModel(1, "mohit", "test comment")
        val data =
            flow { emit(CommentApiState.success(listOf(commentModel))) }
        Mockito.`when`(repositoryImpl.getComments(testDispatcher)).thenReturn(data)
        viewModel.getComments()
        assertTrue(viewModel.commentUIState.first() == CommentUIState.LOADING)
        testDispatcher.scheduler.advanceUntilIdle()
        assertTrue(viewModel.commentUIState.first() is CommentUIState.SUCCESS)
        assertEquals(
            data.first().data?.get(0)?.comment,
            (viewModel.commentUIState.first() as CommentUIState.SUCCESS).data[0].comment
        )
    }

    @Test
    fun checkError() = runTest {
        useCase = CommentUseCase(repositoryImpl)
        val viewModel = CommentViewModel(useCase, testDispatcher)
        val data =
            flow<CommentApiState<List<CommentModel>>> { emit(CommentApiState.error("kutta")) }
        Mockito.`when`(repositoryImpl.getComments(testDispatcher)).thenReturn(data)
        viewModel.getComments()
        assertTrue(viewModel.commentUIState.first() == CommentUIState.LOADING)
        testDispatcher.scheduler.advanceUntilIdle()
        println("================${viewModel.commentUIState.value}")
        assertTrue(viewModel.commentUIState.first() is CommentUIState.FAILURE)

        assertEquals(
            data.first().message,
            (viewModel.commentUIState.first() as CommentUIState.FAILURE).message
        )
    }


    @After
    fun tearDown() {
    }
}