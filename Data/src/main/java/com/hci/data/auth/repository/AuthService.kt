package com.hci.data.auth.repository

import com.hci.data.auth.entity.SectionEntity
import io.reactivex.Single


/**
 * Created by febriansyah on 2020-02-06.
 */
interface AuthService {
    fun getAppInitData(): Single<SectionEntity>
}
