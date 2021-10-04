package com.adrena.basearchitect.features.flows.login.usecase

import com.adrena.basearchitect.core.base.Response
import com.adrena.basearchitect.features.flows.login.datasource.entity.LoginEntityRequest
import com.adrena.basearchitect.features.flows.login.datasource.entity.LoginEntityResponse
import com.adrena.basearchitect.features.flows.login.datasource.repository.ILoginRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCase(private val loginRepository: ILoginRepository) {

    private lateinit var model:LoginEntityRequest

    fun bind() {
        model = LoginEntityRequest(email = "ederdoski19@gmail.com", password = "1234")
    }

    suspend fun execute(): Flow<Response<LoginEntityResponse>> {
        return loginRepository.callLogin(model)
    }
}
