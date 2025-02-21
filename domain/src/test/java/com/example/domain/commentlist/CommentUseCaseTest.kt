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
        val dataExpected =
            listOf(
                commentModel
            )

        Mockito.`when`(repositoryImpl.getComments()).thenReturn(dataExpected)
        val actualResult = useCase.invoke()
        verify(repositoryImpl).getComments()
        assertEquals(dataExpected[0].comment, actualResult[0].comment)
        assertEquals(dataExpected[0].name, actualResult[0].name)
        assertEquals(dataExpected[0].postId, actualResult[0].postId)
    }

    @After
    fun tearDown() {
    }
}