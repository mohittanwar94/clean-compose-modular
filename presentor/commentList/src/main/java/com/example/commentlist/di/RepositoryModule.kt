package com.example.commentlist.di

import com.example.data.commentlist.CommentApi
import com.example.data.commentlist.CommentRepositoryImpl
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