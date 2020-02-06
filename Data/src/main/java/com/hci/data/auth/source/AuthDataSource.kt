package com.hci.data.auth.source

import com.hci.auth.model.SectionModel
import com.hci.auth.repository.AuthRepository
import com.hci.data.auth.repository.AuthService
import dagger.Lazy
import io.reactivex.Single
import javax.inject.Inject


/**
 * Created by febriansyah on 2020-02-06.
 */
interface AuthDataSource : AuthRepository {

    class Factory
    @Inject constructor(private val network: Lazy<Network>) {
        fun network(): Network = network.get()
    }

    class Network
    @Inject constructor(private val service: AuthService) : AuthDataSource{
        override fun getAppInitData(): Single<List<SectionModel>> {
            return service.getAppInitData().map { it.create() }
        }
    }
}
