/*
 * Copyright (c) 2021 by Brac-UPG Programme
 * All Rights Reserved by BRAC
 * Powered By BMQA
 * BMQA-BRAC Confidential
 */

package com.fcorp.myapplication.di

import com.fcorp.myapplication.Application
import com.fcorp.myapplication.network.ApiClient
import com.fcorp.myapplication.network.ApiService
import com.fcorp.myapplication.repositories.DefaultLoginRepository
import com.fcorp.myapplication.repositories.LoginRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGson() : Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideApiService() : ApiService {
        return ApiClient.create(Application.getContext())
    }

    @Singleton
    @Provides
    fun provideDefaultLoginRepository(
            apiService: ApiService
    ) = DefaultLoginRepository(apiService) as LoginRepository

}