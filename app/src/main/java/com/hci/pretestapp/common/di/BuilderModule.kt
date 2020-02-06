package com.hci.pretestapp.common.di

import com.hci.pretestapp.home.HomeActivity
import com.hci.pretestapp.home.HomeModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by febriansyah on 2020-02-06.
 */

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = [(HomeModule::class)])
    abstract fun bindHomeActivity(): HomeActivity
}
