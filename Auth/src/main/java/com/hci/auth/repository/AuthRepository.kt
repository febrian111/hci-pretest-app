package com.hci.auth.repository

import com.hci.auth.model.SectionModel
import io.reactivex.Single

interface AuthRepository {
    fun getAppInitData(): Single<List<SectionModel>>
}