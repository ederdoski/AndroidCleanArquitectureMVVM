package com.adrena.basearchitect.features.flows.login.datasource.repository

import com.adrena.basearchitect.features.flows.login.datasource.entity.LoginEntityResponse

interface ListenerLoginService {
    fun onSuccess(data: LoginEntityResponse) {}
    fun onError() {}
}