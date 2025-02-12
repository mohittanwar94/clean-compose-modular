package com.example.data.di

import com.example.data.CommentApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommentApiModule {

    @Provides
    @Singleton
    fun provideCommentApi(
        retrofit: Retrofit,
    ): CommentApi {
        return retrofit.create(CommentApi::class.java)
    }

}