package com.adrena.basearchitect.features.flows.users.module

//--- Koin
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

//--- Retrofit
import retrofit2.Retrofit

import com.adrena.basearchitect.features.flows.users.datasource.repository.IUsersRepository
import com.adrena.basearchitect.features.flows.users.datasource.repository.UsersRepository
import com.adrena.basearchitect.features.flows.users.datasource.service.IUsersService
import com.adrena.basearchitect.features.flows.users.usecase.UsersUseCase
import com.adrena.basearchitect.features.flows.users.viewmodel.UsersVMDelegate
import com.adrena.basearchitect.features.flows.users.viewmodel.UsersViewModel
        
val usersModule : Module =  module {

    //--- Inject viewModel
    viewModel {
        UsersViewModel(
        context = get(),
        usersUseCase = get(),
        delegate = get())
    }
    factory { providerUsersVMDelegate() }

    //--- Inject repository
    single<IUsersRepository> {
        UsersRepository(
            iUsersService = get()
        )
    }
    //--- Inject useCase
    single { providerUsersUseCase(get()) }

    //--- Inject service
    single { providerUsersService(get()) }
}

fun providerUsersVMDelegate(): UsersVMDelegate{
    return UsersVMDelegate()
}

fun providerUsersUseCase(usersRepository: IUsersRepository): UsersUseCase{
    return UsersUseCase(usersRepository)
}

fun providerUsersService(retrofit: Retrofit): IUsersService{
    return retrofit.create(IUsersService::class.java)
}