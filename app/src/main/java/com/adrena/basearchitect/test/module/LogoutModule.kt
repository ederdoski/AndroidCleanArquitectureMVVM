package com.adrena.basearchitect.test.module

//--- Koin
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

//--- Retrofit
import retrofit2.Retrofit

import com.adrena.basearchitect.test.datasource.repository.ILogoutRepository
import com.adrena.basearchitect.test.datasource.repository.LogoutRepository
import com.adrena.basearchitect.test.datasource.service.ILogoutService
import com.adrena.basearchitect.test.usecase.LogoutUseCase
import com.adrena.basearchitect.test.viewmodel.LogoutVMDelegate
import com.adrena.basearchitect.test.viewmodel.LogoutViewModel
        
val logoutModule : Module =  module {

    //--- Inject viewModel
    viewModel {
        LogoutViewModel(
        context = get(),
        logoutUseCase = get(),
        delegate = get())
    }
    factory { providerLogoutVMDelegate() }

    //--- Inject repository
    single<ILogoutRepository> {
        LogoutRepository(
            iLogoutService = get()
        )
    }
    //--- Inject useCase
    single { providerLogoutUseCase(get()) }

    //--- Inject service
    single { providerLogoutService(get()) }
}

fun providerLogoutVMDelegate(): LogoutVMDelegate{
    return LogoutVMDelegate()
}

fun providerLogoutUseCase(logoutRepository: ILogoutRepository): LogoutUseCase{
    return LogoutUseCase(logoutRepository)
}

fun providerLogoutService(retrofit: Retrofit): ILogoutService{
    return retrofit.create(ILogoutService::class.java)
}