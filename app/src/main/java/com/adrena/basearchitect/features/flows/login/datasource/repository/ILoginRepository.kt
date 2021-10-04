package com.adrena.basearchitect.features.flows.login.datasource.repository

import com.adrena.basearchitect.core.base.Response
import com.adrena.basearchitect.features.flows.login.datasource.entity.LoginEntityRequest
import com.adrena.basearchitect.features.flows.login.datasource.entity.LoginEntityResponse
import kotlinx.coroutines.flow.Flow
import kotlin.jvm.Throws

interface ILoginRepository {

    @Throws(Exception::class)
    suspend fun callLogin(model: LoginEntityRequest): Flow<Response<LoginEntityResponse>>

}