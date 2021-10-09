package com.adrena.basearchitect.test.datasource.repository

import kotlinx.coroutines.flow.Flow
import com.adrena.basearchitect.core.base.Response
import com.adrena.basearchitect.test.datasource.entity.LogoutEntityResponse

interface ILogoutRepository {

    @Throws(Exception::class)
    suspend fun callGetSomeMethod(): Flow<Response<LogoutEntityResponse>>
}        