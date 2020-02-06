package com.hci.auth.usecase

import com.hci.auth.model.ProductModel
import com.hci.auth.model.SectionModel
import com.hci.auth.repository.AuthRepository
import com.hci.kit.base.UseCase
import com.hci.kit.constant.TagInjectConstant
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class GetAppInitDataUseCase
@Inject constructor(private val repository: AuthRepository,
                    @Named(TagInjectConstant.SCHEDULER_EXECUTION) threadExecutor: Scheduler,
                    @Named(TagInjectConstant.SCHEDULER_POST_EXECUTION) postExecutionThread: Scheduler
) : UseCase.RxSingle<SectionModel, Unit>(threadExecutor, postExecutionThread){
    override fun build(params: Unit?): Single<SectionModel> {
        return repository.getAppInitData()
    }
}