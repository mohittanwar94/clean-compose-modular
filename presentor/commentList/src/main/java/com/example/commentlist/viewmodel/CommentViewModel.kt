package com.example.commentlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.corenetwork.di.IoDispatcher
import com.example.corenetwork.network.Status
import com.example.domain.CommentModel
import com.example.domain.CommentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
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
            commentUseCase.invoke(dispatcher).catch {
                _commentState.value = CommentUIState.FAILURE(it.message ?: "error in call")
            }.collect { response ->
                _commentState.value = when (response.status) {
                    Status.SUCCESS ->
                        response.data?.let {
                            CommentUIState.SUCCESS(it)
                        } ?: run {
                            CommentUIState.FAILURE("Data Not Found")
                        }

                    Status.ERROR ->
                        CommentUIState.FAILURE(response.message ?: "Unknown error")

                    Status.LOADING -> CommentUIState.LOADING
                }
            }
        }
    }
}

sealed class CommentUIState {
    object LOADING : CommentUIState()
    data class SUCCESS(val data: List<CommentModel>) : CommentUIState()
    data class FAILURE(val message: String) : CommentUIState()
}