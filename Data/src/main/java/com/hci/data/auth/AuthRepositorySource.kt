package com.hci.data.auth

import com.hci.auth.model.SectionModel
import com.hci.auth.repository.AuthRepository
import com.hci.data.auth.source.AuthDataSource
import io.reactivex.Single
import javax.inject.Inject


/**
 * Created by febriansyah on 2020-02-06.
 */
class AuthRepositorySource
@Inject constructor(private val factory: AuthDataSource.Factory) : AuthRepository {
    override fun getAppInitData(): Single<SectionModel> {
        return factory.network().getAppInitData()
    }
}
