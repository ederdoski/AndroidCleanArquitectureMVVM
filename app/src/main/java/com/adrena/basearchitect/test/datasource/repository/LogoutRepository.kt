package com.adrena.basearchitect.test.datasource.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

import com.adrena.basearchitect.test.datasource.entity.LogoutEntityResponse

import com.adrena.basearchitect.core.base.BaseRepository
import com.adrena.basearchitect.core.base.NetworkResponse
import com.adrena.basearchitect.core.base.Response
import com.adrena.basearchitect.test.datasource.service.ILogoutService
import com.adrena.basearchitect.test.datasource.entity.LogoutEntityRequest
import kotlin.jvm.Throws

class LogoutRepository(
    private val iLogoutService: ILogoutService
): ILogoutRepository, BaseRepository() {

    @Throws(Exception::class)
    override suspend fun callGetSomeMethod(): Flow<Response<LogoutEntityResponse>>  = flow {
        val responseNetwork = iLogoutService.getSomeMethod(LogoutEntityRequest())
        val response = NetworkResponse(responseNetwork!!)

        if (response.exception != null) {
            emit(Response.Failure(response.exception!!))
        } else {
            emit(Response.Success(response.response!!))
        }
    }.catch {
        Log.e("callLogin", "CATCH")
    }

}        