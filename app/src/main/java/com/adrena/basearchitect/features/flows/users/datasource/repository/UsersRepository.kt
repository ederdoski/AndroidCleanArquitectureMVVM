package com.adrena.basearchitect.features.flows.users.datasource.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

import com.adrena.basearchitect.features.flows.users.datasource.entity.UsersEntityResponse

import com.adrena.basearchitect.core.base.BaseRepository
import com.adrena.basearchitect.core.base.NetworkResponse
import com.adrena.basearchitect.core.base.Response
import com.adrena.basearchitect.features.flows.users.datasource.service.IUsersService
import com.adrena.basearchitect.features.flows.users.datasource.entity.UsersEntityRequest
import kotlin.jvm.Throws

class UsersRepository(
    private val iUsersService: IUsersService
): IUsersRepository, BaseRepository() {

    @Throws(Exception::class)
    override suspend fun callGetSomeMethod(): Flow<Response<UsersEntityResponse>>  = flow {
        val responseNetwork = iUsersService.getSomeMethod(UsersEntityRequest())
        val response = NetworkResponse(responseNetwork!!)

        if (response.exception != null) {
            emit(Response.Failure(response.exception!!))
        } else {
            emit(Response.Success(response.response!!))
        }
    }.catch {
        emit(Response.Success(UsersEntityResponse("")))
    }

}        