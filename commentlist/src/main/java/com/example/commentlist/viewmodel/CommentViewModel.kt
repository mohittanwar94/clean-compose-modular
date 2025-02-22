package com.example.commentlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.corenetwork.di.IoDispatcher
import com.example.domain.commentlist.CommentModel
import com.example.domain.commentlist.CommentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(
    private val commentUseCase: CommentUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _commentState = MutableStateFlow<CommentUIState>(CommentUIState.LOADING)
    val commentUIState = _commentState.asStateFlow()

    init {
        getComments()
    }

    private fun getComments() {
        _commentState.value = CommentUIState.LOADING
        viewModelScope.launch(dispatcher) {
            _commentState.value = try {
                val result = commentUseCase.invoke()
                CommentUIState.SUCCESS(result)
            } catch (e: Exception) {
                CommentUIState.FAILURE(e.message ?: "Exception at calling")
            }
        }
    }
}

sealed class CommentUIState {
    data object LOADING : CommentUIState()
    data class SUCCESS(val data: List<CommentModel>) : CommentUIState()
    data class FAILURE(val message: String) : CommentUIState()
}