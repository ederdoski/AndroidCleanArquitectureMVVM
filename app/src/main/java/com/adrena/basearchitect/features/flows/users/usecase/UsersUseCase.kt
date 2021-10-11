package com.adrena.basearchitect.features.flows.users.usecase

import kotlinx.coroutines.flow.Flow
import com.adrena.basearchitect.core.base.Response
import com.adrena.basearchitect.features.flows.users.datasource.entity.UsersEntityResponse
import com.adrena.basearchitect.features.flows.users.datasource.repository.IUsersRepository
import java.io.InputStream

class UsersUseCase(private val usersRepository: IUsersRepository) {

    fun bind() {
        //--- Set your request object
    }
    
    suspend fun execute(): Flow<Response<UsersEntityResponse>>{
        return usersRepository.callGetSomeMethod()
    }
}