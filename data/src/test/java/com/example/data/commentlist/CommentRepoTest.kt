package com.example.data.commentlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.corenetwork.network.ResultWrapper
import com.example.data.utils.Constants
import com.example.data.utils.CoroutineTestRule
import com.example.domain.commentlist.CommentModel
import com.example.domain.commentlist.CommentRepository
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
    fun checkSuccessDataIsThereOrNot() = runTest {
        val commentModel = CommentModel(Constants.POST_ID_1, Constants.Name_1, Constants.Comment_1)
        val commentModel1 =
            CommentModel(Constants.POST_ID_111, Constants.Name_111, Constants.Comment_111)
        val listComment = listOf(commentModel, commentModel1)
        val expectedData = ResultWrapper.Success(listComment)
        Mockito.`when`(repositoryImpl.getComments(testDispatcher)).thenReturn(expectedData)
        val actualResult = repositoryImpl.getComments(testDispatcher)
        testDispatcher.scheduler.advanceUntilIdle()
        assertTrue(actualResult is ResultWrapper.Success)
        verify(repositoryImpl).getComments(testDispatcher)
        val list = ArrayList<CommentModel>()
        if (actualResult is ResultWrapper.Success)
            list.addAll(actualResult.data)
        assertEquals(expectedData.data[1].comment, list[1].comment)
    }

    @Test
    fun checkErrorInRepository() = runTest {
        val dataExpected =
            ResultWrapper.Failure<Nothing>(Constants.Error_MSG)
        Mockito.`when`(repositoryImpl.getComments(testDispatcher)).thenReturn(dataExpected)
        val actualResult = repositoryImpl.getComments(testDispatcher)
        testDispatcher.scheduler.advanceUntilIdle()
        assertTrue(actualResult is ResultWrapper.Failure)
        verify(repositoryImpl).getComments(testDispatcher)
        val msgActual = (actualResult as ResultWrapper.Failure).msg
        assertEquals(dataExpected.msg, msgActual)
    }


    @After
    fun tearDown() {
    }
}