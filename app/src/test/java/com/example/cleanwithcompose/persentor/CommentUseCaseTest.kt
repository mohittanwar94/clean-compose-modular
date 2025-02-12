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
class CommentUseCaseTest {


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
    fun checkSuccessUseCase() = runTest {
        useCase = CommentUseCase(repositoryImpl)
        val commentModel = CommentModel(1, "mohit", "test comment")
        val data =
            flow<CommentApiState<List<CommentModel>>> {
                emit(
                    CommentApiState.success(
                        listOf(
                            commentModel
                        )
                    )
                )
            }
        Mockito.`when`(repositoryImpl.getComments(testDispatcher)).thenReturn(data)
        val actualResult = useCase.invoke(testDispatcher)
        println("=====================${actualResult.first().data?.get(0)?.comment}")
        assertEquals(data.first().data?.get(0)?.comment, actualResult.first().data?.get(0)?.comment)
        assertEquals(data.first().data?.get(0)?.name, actualResult.first().data?.get(0)?.name)
        assertEquals(data.first().data?.get(0)?.postId, actualResult.first().data?.get(0)?.postId)
    }

    @Test
    fun checkErrorUseCase() = runTest {
        useCase = CommentUseCase(repositoryImpl)
        val data =
            flow<CommentApiState<List<CommentModel>>> { emit(CommentApiState.error("Custom Error")) }
        Mockito.`when`(repositoryImpl.getComments(testDispatcher)).thenReturn(data)
        val actualResult = useCase.invoke(testDispatcher)
        assertEquals("Custom Error", actualResult.first().message)
    }


    @Test(expected = RuntimeException::class)
    fun checkExceptionrUseCase() = runTest {
        useCase = CommentUseCase(repositoryImpl)
        val data =
            flow<CommentApiState<CommentModel>> { emit(CommentApiState.error("error in usecase")) }
        Mockito.`when`(repositoryImpl.getComments(testDispatcher))
            .thenThrow(RuntimeException::class.java)
        val actualResult = useCase.invoke(testDispatcher)
        assertEquals("error in usecase", actualResult.first().message)
    }


    @After
    fun tearDown() {
    }
}