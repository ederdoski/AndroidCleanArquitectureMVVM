package com.adrena.basearchitect.features.flows.login.module

import com.adrena.basearchitect.features.flows.login.datasource.repository.ILoginRepository
import com.adrena.basearchitect.features.flows.login.datasource.repository.LoginRepository
import com.adrena.basearchitect.features.flows.login.datasource.service.ILoginService
import com.adrena.basearchitect.features.flows.login.usecase.LoginUseCase
import com.adrena.basearchitect.features.flows.login.viewmodel.LoginVMDelegate
import com.adrena.basearchitect.features.flows.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val loginModule: Module = module {

    //--- Inject viewModel
    viewModel {
        LoginViewModel(
            context = get(),
            delegate = get(),
            loginUseCase = get()
        )
    }
    factory { providerLoginVMDelegate() }

    //--- Inject repository
    single<ILoginRepository> {
        LoginRepository(
            iLoginService = get()
        )
    }

    //--- Inject useCase
    single { providerLoginUseCase(get()) }

    //--- Inject service
    single { providerLoginService(get()) }
}

fun providerLoginVMDelegate(): LoginVMDelegate {
    return LoginVMDelegate()
}

fun providerLoginUseCase(loginRepository: ILoginRepository): LoginUseCase {
    return LoginUseCase(
        loginRepository
    )
}

fun providerLoginService(retrofit: Retrofit): ILoginService{
    return retrofit.create(ILoginService::class.java)
}
