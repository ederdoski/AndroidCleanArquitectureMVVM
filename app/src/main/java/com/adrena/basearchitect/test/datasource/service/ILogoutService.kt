package com.adrena.basearchitect.test.datasource.service

import com.adrena.basearchitect.test.datasource.entity.LogoutEntityResponse
import com.adrena.basearchitect.test.datasource.entity.LogoutEntityRequest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ILogoutService {

    //---Example api client method
    @GET("qry/api-example/some-method")
    suspend fun getSomeMethod(@Query("request") entityRequest: LogoutEntityRequest): Response<LogoutEntityResponse>
}        