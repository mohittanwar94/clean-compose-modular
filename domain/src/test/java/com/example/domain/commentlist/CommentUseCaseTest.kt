package com.example.domain.commentlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.corenetwork.network.ResultWrapper
import com.example.domain.utils.Constants
import com.example.domain.utils.Constants.Error_MSG
import com.example.domain.utils.Constants.Runtime_Error_MSG
import com.example.domain.utils.CoroutineTestRule
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
import org.mockito.kotlin.verify


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
    fun checkSuccessUseCaseHaveSuccessDataOrNot() = runTest {
        useCase = CommentUseCase(repositoryImpl)
        val commentModel = CommentModel(1, Constants.Name, Constants.Comment)
        val dataExpected = ResultWrapper.Success(
            listOf(
                commentModel
            )
        )
        Mockito.`when`(repositoryImpl.getComments(testDispatcher)).thenReturn(dataExpected)
        val actualResult = useCase.invoke(testDispatcher)
        val dataActual = ArrayList<CommentModel>()
        assertTrue(actualResult is ResultWrapper.Success)
        dataActual.addAll((actualResult as ResultWrapper.Success).data)
        verify(repositoryImpl).getComments(testDispatcher)
        assertEquals(dataExpected.data[0].comment, dataActual[0].comment)
        assertEquals(dataExpected.data[0].name, dataActual[0].name)
        assertEquals(dataExpected.data[0].postId, dataActual[0].postId)
    }

    @Test
    fun checkErrorUseCase() = runTest {
        useCase = CommentUseCase(repositoryImpl)
        val dataExpected =
            ResultWrapper.Failure<Nothing>(Error_MSG)
        Mockito.`when`(repositoryImpl.getComments(testDispatcher)).thenReturn(dataExpected)
        val actualResult = useCase.invoke(testDispatcher)
        verify(repositoryImpl).getComments(testDispatcher)
        assertTrue(actualResult is ResultWrapper.Failure)
        val message: String = (actualResult as ResultWrapper.Failure).msg
        assertEquals(Error_MSG, message)
    }


    @Test(expected = RuntimeException::class)
    fun checkExceptionInUseCase() = runTest {
        useCase = CommentUseCase(repositoryImpl)
        val dataExpected =
            ResultWrapper.Failure<String>(Runtime_Error_MSG)
        Mockito.`when`(repositoryImpl.getComments(testDispatcher))
            .thenThrow(RuntimeException::class.java)
        val actualResult = useCase.invoke(testDispatcher)
        verify(repositoryImpl).getComments(testDispatcher)
        assertTrue(actualResult is ResultWrapper.Failure)
        val message: String = (actualResult as ResultWrapper.Failure).msg
        assertEquals(dataExpected.msg, message)
    }


    @After
    fun tearDown() {
    }
}