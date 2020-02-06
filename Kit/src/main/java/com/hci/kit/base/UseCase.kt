package com.hci.kit.base

import com.hci.kit.extension.disposedBy
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

abstract class UseCase<out Type, in Params> protected constructor(
    private val threadExecutor: Scheduler,
    private val postExecutionThread: Scheduler
) {

    protected val disposables = CompositeDisposable()

    abstract fun build(params: Params?): Type

    fun dispose() = disposables.dispose()

    abstract class RxSingle<T, in P> protected constructor(
        private val threadExecutor: Scheduler,
        private val postExecutionThread: Scheduler
    )
        : UseCase<Single<T>, P>(threadExecutor, postExecutionThread) {
        fun execute(observer: DisposableSingleObserver<T>, params: P? = null) {
            build(params)
                .subscribeOn(threadExecutor)
                .observeOn(postExecutionThread)
                .subscribeWith(observer)
                .disposedBy(disposables)
        }
    }
}
