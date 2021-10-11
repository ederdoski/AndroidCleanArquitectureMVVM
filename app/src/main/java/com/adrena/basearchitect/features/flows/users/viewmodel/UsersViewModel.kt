package com.adrena.basearchitect.features.flows.users.viewmodel

import android.content.Context

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import com.adrena.basearchitect.core.base.Response
import com.adrena.basearchitect.core.exception.NotNetworkException
import com.adrena.basearchitect.features.flows.users.datasource.entity.UsersEntityResponse

import com.adrena.basearchitect.features.flows.users.usecase.UsersUseCase
import com.adrena.basearchitect.features.flows.users.viewmodel.UsersVMDelegate

class UsersViewModel(
private val context: Context,
private val usersUseCase: UsersUseCase,
val delegate: UsersVMDelegate
) : ViewModel() {

    fun callGetSomeMethod() {
        viewModelScope.launch {
            usersUseCase.bind()
            usersUseCase.execute().collect {
                when (it) {
                    is Response.Success<UsersEntityResponse> -> {
                        delegate.onPostSetUsersValue()
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