package com.hci.pretestapp.staticpage

import androidx.lifecycle.ViewModelProvider
import asia.digiasia.kaspro.staticpage.StaticPageViewModel
import asia.digiasia.kaspro.staticpage.StaticPageViewModelType
import dagger.Module
import dagger.Provides


@Module
class StaticPageModule {

    @Provides
    fun provideViewModel(activity: StaticPageActivity, factory: StaticPageViewModel.Factory):
            StaticPageViewModelType {
        return ViewModelProvider(activity, factory).get(StaticPageViewModel::class.java)
    }
}
