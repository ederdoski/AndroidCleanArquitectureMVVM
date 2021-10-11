package com.adrena.basearchitect.features.flows.users.datasource.service

import com.adrena.basearchitect.features.flows.users.datasource.entity.UsersEntityResponse
import com.adrena.basearchitect.features.flows.users.datasource.entity.UsersEntityRequest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IUsersService {

    //---Example api client method
    @GET("qry/api-example/some-method")
    suspend fun getSomeMethod(@Query("request") entityRequest: UsersEntityRequest): Response<UsersEntityResponse>
}        