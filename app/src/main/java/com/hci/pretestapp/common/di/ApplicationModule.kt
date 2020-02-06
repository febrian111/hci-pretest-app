package com.hci.pretestapp.common.di

import android.app.Application
import com.hci.kit.constant.TagInjectConstant
import com.hci.pretestapp.BuildConfig
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by febriansyah on 2020-02-06.
 */


@Module
class ApplicationModule {

    @Provides
    @Named(TagInjectConstant.SCHEDULER_EXECUTION)
    fun provideExecutionScheduler() = Schedulers.io()

    @Provides
    @Named(TagInjectConstant.SCHEDULER_POST_EXECUTION)
    fun providePostExecutionScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Singleton
    @Named(TagInjectConstant.APP_INIT_URL_KASPRO)
    fun provideAppInitKasproUrl() = BuildConfig.base_url

}
