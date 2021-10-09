package com.adrena.basearchitect.test.viewmodel

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

import com.adrena.basearchitect.test.usecase.LogoutUseCase
import com.adrena.basearchitect.test.viewmodel.LogoutVMDelegate

class LogoutViewModel(
private val context: Context,
private val logoutUseCase: LogoutUseCase,
val delegate: LogoutVMDelegate
) : ViewModel() {

    /*
    Ejemplo de ejecución sobre un caso de uso
    
    @ExperimentalCoroutinesApi
    @InternalCoroutinesApi
    fun callGetStores(latitude: Double?, longitude: Double?) {

        viewModelScope.launch {
            storeUseCase.binData(latitude, longitude)
            executeSimpleUseCase(storeUseCase, configuration).single().collect {
                println("DATOS ESPERADO=" + it.toString())
                when (it) {
                    is Response.Success<List<Store>> -> {
                        val storeSubsidiaryId = it.successData.joinToString { store ->
                            store.storeSubsidiariId
                        }
                        userDataPreferences.saveSubsidiariesId(storeSubsidiaryId)
                        mutableListStoresLiveData.value =
                            StoreModelMapper.listStoreToListStoreModel(it.successData)
                    }

                    is Response.Failure<Exception> -> {
                        when (it.errorData) {
                            is NotNetworkException -> {
                                mutableErrorNetworkLiveData.value = true
                            }
                            is GenericExceptionModel -> {
                                mutableErrorGenericLiveData.value = true
                            }
                        }
                    }
                }
            }
        }
    }
     */
}