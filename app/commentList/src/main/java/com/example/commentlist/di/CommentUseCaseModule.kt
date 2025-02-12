package com.example.data.di

import com.example.domain.CommentRepository
import com.example.domain.CommentUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommentUseCaseModule {

    @Provides
    @Singleton
    fun provideCommentUseCase(
        repository: CommentRepository,
    ) = CommentUseCase(repository)
}