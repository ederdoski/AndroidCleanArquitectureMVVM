package com.adrena.basearchitect.features.flows.login.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrena.basearchitect.core.base.Response
import com.adrena.basearchitect.core.exception.NotNetworkException
import com.adrena.basearchitect.features.flows.login.datasource.entity.LoginEntityResponse
import com.adrena.basearchitect.features.flows.login.usecase.LoginUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginViewModel (
    private val context: Context,
    private val loginUseCase:LoginUseCase,
    val delegate: LoginVMDelegate,
): ViewModel() {

    fun callLogin() {
        viewModelScope.launch {
            loginUseCase.bind()
            loginUseCase.execute().collect {
                when (it) {
                    is Response.Success<LoginEntityResponse> -> {
                        delegate.onLoginPostValue(it.successData)
                    }
                    is Response.Failure<Exception> -> {
                        if (it.errorData is NotNetworkException) {
                            delegate.showNetworkErrorPostValue()
                        } else {
                            delegate.showUnknownErrorPostValue()
                        }
                    }
                }
            }
        }
    }
}