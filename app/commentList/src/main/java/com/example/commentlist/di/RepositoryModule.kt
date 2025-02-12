package com.example.data.di

import com.example.data.CommentApi
import com.example.data.CommentRepositoryImpl
import com.example.domain.CommentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCommentRepository(
        apiInterface: CommentApi,
    ): CommentRepository =
        CommentRepositoryImpl(apiInterface)


}