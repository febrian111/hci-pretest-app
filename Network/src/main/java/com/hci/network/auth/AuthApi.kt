package com.hci.network.auth

import com.hci.data.auth.entity.SectionEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface AuthApi {

    @GET
    fun getAppInitData(@Url url: String): Single<SectionEntity>
}
