package com.adrena.basearchitect.test.usecase

import kotlinx.coroutines.flow.Flow
import com.adrena.basearchitect.core.base.Response
import com.adrena.basearchitect.test.datasource.entity.LogoutEntityResponse
import com.adrena.basearchitect.test.datasource.repository.ILogoutRepository
import java.io.InputStream

class LogoutUseCase(private val logoutRepository: ILogoutRepository) {

    fun bind() {
        //--- Set your request object
    }
    
    suspend fun execute(): Flow<Response<LogoutEntityResponse>>{
        return logoutRepository.callGetSomeMethod()
    }
}