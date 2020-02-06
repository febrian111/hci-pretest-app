package com.hci.data.di

import com.hci.auth.repository.AuthRepository
import com.hci.data.auth.AuthRepositorySource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideAuthRepository(githubRepositorySource: AuthRepositorySource)
            : AuthRepository = githubRepositorySource
}
