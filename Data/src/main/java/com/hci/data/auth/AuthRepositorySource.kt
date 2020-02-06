package com.hci.data.auth

import com.hci.auth.model.SectionModel
import com.hci.auth.repository.AuthRepository
import com.hci.data.auth.source.AuthDataSource
import io.reactivex.Single
import javax.inject.Inject



class AuthRepositorySource
@Inject constructor(private val factory: AuthDataSource.Factory) : AuthRepository {
    override fun getAppInitData(): Single<List<SectionModel>> {
        return factory.network().getAppInitData()
    }
}
