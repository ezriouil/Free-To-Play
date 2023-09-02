package com.ezriouil.freetoplay.di

import com.ezriouil.freetoplay.data.remote.Api
import com.ezriouil.freetoplay.data.repository.GameRepositoryImpl
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
    fun provideGameRepositoryImpl(api: Api): GameRepositoryImpl {
        return GameRepositoryImpl(api)
    }
}