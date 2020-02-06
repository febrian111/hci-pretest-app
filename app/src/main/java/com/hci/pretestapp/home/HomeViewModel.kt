package com.hci.pretestapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hci.auth.model.SectionModel
import com.hci.auth.usecase.GetAppInitDataUseCase
import com.hci.pretestapp.common.base.ViewModelType
import io.reactivex.Observable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject


/**
 * Created by febriansyah on 2020-02-06.
 */

interface HomeViewModelType : ViewModelType {
    val inputs: Inputs
    val outputs: Outputs

    interface Inputs {
        fun onViewLoaded()
    }

    interface Outputs {
        val showDialogMessage: Observable<Any>
        val showProgressBar: Observable<Boolean>
        val showErrorPage: Observable<Boolean>
    }
}

class HomeViewModel(private val getAppInitDataUseCase: GetAppInitDataUseCase) : ViewModel(),
    HomeViewModelType,
    HomeViewModelType.Inputs,
    HomeViewModelType.Outputs {

    private val showDialogMessageSubject = PublishSubject.create<Any>()
    private val progressBarSubject = PublishSubject.create<Boolean>()
    private val showErrorPageSubject = PublishSubject.create<Boolean>()

    override val inputs: HomeViewModelType.Inputs
        get() = this
    override val outputs: HomeViewModelType.Outputs
        get() = this

    override val showDialogMessage: Observable<Any>
        get() = showDialogMessageSubject
    override val showProgressBar: Observable<Boolean>
        get() = progressBarSubject
    override val showErrorPage: Observable<Boolean>
        get() = showErrorPageSubject

    override fun onViewLoaded() {
        progressBarSubject.onNext(true)
        getAppInitDataUseCase.execute(DataInitObserver())
    }

    inner class DataInitObserver : DisposableSingleObserver<SectionModel>() {
        override fun onSuccess(t: SectionModel) {
            showErrorPageSubject.onNext(false)
            progressBarSubject.onNext(false)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            showErrorPageSubject.onNext(true)
            progressBarSubject.onNext(false)
        }

    }

    @Suppress("UNCHECKED_CAST")
    class Factory
    @Inject constructor(private val getAppInitDataUseCase: GetAppInitDataUseCase) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
                return HomeViewModel(getAppInitDataUseCase) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}