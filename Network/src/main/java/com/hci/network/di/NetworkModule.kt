package com.fbr.trendinggithub.network.di

import com.hci.network.extension.defaultBuilder
import com.hci.kit.constant.TagInjectConstant
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    @Named(TagInjectConstant.RETROFIT)
    fun provideRetrofit(
        @Named(TagInjectConstant.OKHTTP) okHttpClient: OkHttpClient,
        @Named(TagInjectConstant.APP_INIT_URL_KASPRO) baseUrl: String)
            : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named(TagInjectConstant.OKHTTP)
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .defaultBuilder()
            .build()
    }
}
