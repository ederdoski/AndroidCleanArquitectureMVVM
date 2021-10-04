package com.adrena.basearchitect.features.flows.login.datasource.service

import com.adrena.basearchitect.features.flows.login.datasource.entity.LoginEntityRequest
import com.adrena.basearchitect.features.flows.login.datasource.entity.LoginEntityResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ILoginService {

    @POST("login")
    suspend fun attemptLogin(@Body login: LoginEntityRequest): Response<LoginEntityResponse>

}