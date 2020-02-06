package com.hci.pretestapp.home

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import dagger.Module
import dagger.Provides


/**
 * Created by febriansyah on 2020-02-06.
 */

@Module
class HomeModule {

    @Provides
    fun provideViewModel(activity: HomeActivity, factory: HomeViewModel.Factory):
            HomeViewModelType {
        return ViewModelProvider(activity, factory).get(HomeViewModel::class.java)
    }

    @Provides
    fun provideHomeMenuRecyclerViewAdapter(): FastItemAdapter<IItem<*, *>> {
        return FastItemAdapter()
    }
}
