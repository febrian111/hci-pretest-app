package com.hci.network.auth

import com.hci.data.auth.entity.SectionEntity
import com.hci.data.auth.repository.AuthService
import io.reactivex.Single
import retrofit2.Retrofit

class AuthServiceImpl(
    private val retrofit: Retrofit): AuthService {

    private val authService by lazy { retrofit.create(AuthApi::class.java) }

    override fun getAppInitData(): Single<SectionEntity> {
        return authService.getAppInitData("home")
    }

}