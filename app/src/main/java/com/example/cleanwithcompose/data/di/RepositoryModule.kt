package com.example.cleanwithcompose.data.di

import com.example.cleanwithcompose.data.ApiInterface
import com.example.cleanwithcompose.data.CommentRepositoryImpl
import com.example.cleanwithcompose.domain.CommentRepository
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
        apiInterface: ApiInterface,
    ): CommentRepository =
        CommentRepositoryImpl(apiInterface)


}