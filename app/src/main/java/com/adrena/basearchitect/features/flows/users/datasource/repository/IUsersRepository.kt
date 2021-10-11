package com.adrena.basearchitect.features.flows.users.datasource.repository

import kotlinx.coroutines.flow.Flow
import com.adrena.basearchitect.core.base.Response
import com.adrena.basearchitect.features.flows.users.datasource.entity.UsersEntityResponse

interface IUsersRepository {

    @Throws(Exception::class)
    suspend fun callGetSomeMethod(): Flow<Response<UsersEntityResponse>>
}        