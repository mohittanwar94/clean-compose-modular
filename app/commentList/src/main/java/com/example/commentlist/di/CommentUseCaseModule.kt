package com.example.commentlist.di

import com.example.domain.commentlist.CommentRepository
import com.example.domain.commentlist.CommentUseCase
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