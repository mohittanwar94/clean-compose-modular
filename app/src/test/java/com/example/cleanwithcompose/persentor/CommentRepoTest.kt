package com.example.cleanwithcompose.persentor

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cleanwithcompose.CoroutineTestRule
import com.example.cleanwithcompose.data.network.CommentApiState
import com.example.cleanwithcompose.domain.CommentModel
import com.example.cleanwithcompose.domain.CommentRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class CommentRepoTest {


    @Mock
    private lateinit var repositoryImpl: CommentRepository

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
        val commentModel = CommentModel(1, "mohit", "test comment")
        val commentModel1 = CommentModel(111, "mohit11", "test comment11")
        val listComment= listOf(commentModel,commentModel1)
        val data =
            flow { emit(CommentApiState.success(listComment)) }
        Mockito.`when`(repositoryImpl.getComments( testDispatcher)).thenReturn(data)
        val actualResult = repositoryImpl.getComments( testDispatcher)
        verify(repositoryImpl).getComments(testDispatcher)
        assertEquals(data.first().data?.get(1)?.comment, actualResult.first().data?.get(1)?.comment)
    }

    @Test
    fun checkError() = runTest {
        val data =
            flow<CommentApiState<List<CommentModel>>> { emit(CommentApiState.error("error")) }
        Mockito.`when`(repositoryImpl.getComments( testDispatcher)).thenReturn(data)
        val actualResult = repositoryImpl.getComments( testDispatcher)
        assertEquals("error", actualResult.first().message)
    }


    @After
    fun tearDown() {
    }
}