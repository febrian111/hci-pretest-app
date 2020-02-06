package com.hci.pretestapp.common.di

import android.app.Application
import com.hci.network.di.NetworkModule
import com.hci.data.di.DataModule
import com.hci.pretestapp.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Created by febriansyah on 2020-02-06.
 */


@Singleton
@Component(
    modules = [
        (AndroidSupportInjectionModule::class),
        (BuilderModule::class),
        (ApplicationModule::class),
        (NetworkModule::class),
        (DataModule::class)
    ]
)
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: MyApplication)
}
