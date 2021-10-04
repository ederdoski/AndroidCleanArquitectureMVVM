package com.adrena.basearchitect.features.flows.login.datasource.repository

import android.util.Log
import com.adrena.basearchitect.core.base.BaseRepository
import com.adrena.basearchitect.core.base.NetworkResponse
import com.adrena.basearchitect.core.base.Response
import com.adrena.basearchitect.features.flows.login.datasource.entity.LoginEntityRequest
import com.adrena.basearchitect.features.flows.login.datasource.entity.LoginEntityResponse
import com.adrena.basearchitect.features.flows.login.datasource.service.ILoginService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlin.jvm.Throws

class LoginRepository(
    private val iLoginService: ILoginService
) : ILoginRepository, BaseRepository() {

    @Throws(Exception::class)
    override suspend fun callLogin(model: LoginEntityRequest) : Flow<Response<LoginEntityResponse>> = flow {
        val responseNetwork = iLoginService.attemptLogin(model)
        val response = NetworkResponse(responseNetwork)
        if (response.exception != null) {
            emit(Response.Failure(response.exception!!))
        } else {
            emit(Response.Success(response.response!!))
        }
    }.catch {
        Log.e("callLogin", "CATCH")
    }
}