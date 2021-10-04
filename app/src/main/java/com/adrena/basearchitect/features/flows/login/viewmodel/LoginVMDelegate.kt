package com.adrena.basearchitect.features.flows.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adrena.basearchitect.core.extensions.Event
import com.adrena.basearchitect.features.flows.login.datasource.entity.LoginEntityResponse

class LoginVMDelegate {

    //region Generic actions
    //region Show progress view
    private val _showProgress = MutableLiveData<Event<Unit>>()
    val showProgress: LiveData<Event<Unit>> get() = _showProgress
    fun showProgressPostValue() {
        _showProgress.value = Event(Unit)
    }
    //endregion
    //region Hide progress view
    private val _hideProgress = MutableLiveData<Event<Unit>>()
    val hideProgress: LiveData<Event<Unit>> get() = _hideProgress
    fun hideProgressPostValue() {
        _hideProgress.value = Event(Unit)
    }
    //endregion
    //region Show Network error
    private val _showNetworkError = MutableLiveData<Event<Unit>>()
    val showNetworkError: LiveData<Event<Unit>> get() = _showNetworkError
    fun showNetworkErrorPostValue() {
        _showNetworkError.value = Event(Unit)
    }
    //endregion
    //region Hide Network error
    private val _hideNetworkError = MutableLiveData<Event<Unit>>()
    val hideNetworkError: LiveData<Event<Unit>> get() = _hideNetworkError
    fun hideNetworkErrorPostValue() {
        _hideNetworkError.value = Event(Unit)
    }
    //endregion
    //region Show Unknown error
    private val _showUnknownError = MutableLiveData<Event<Unit>>()
    val showUnknownError: LiveData<Event<Unit>> get() = _showUnknownError
    fun showUnknownErrorPostValue() {
        _showUnknownError.value = Event(Unit)
    }
    //endregion
    //region Hide Unknown error
    private val _hideUnknownError = MutableLiveData<Event<Unit>>()
    val hideUnknownError: LiveData<Event<Unit>> get() = _hideUnknownError
    fun hideUnknownErrorPostValue() {
        _hideUnknownError.value = Event(Unit)
    }
    //endregion
    //region onLoginUpdate
    //region Show onLoginUpdate
    private val _onLoginUpdate = MutableLiveData<Event<LoginEntityResponse>>()
    val onLoginUpdate: LiveData<Event<LoginEntityResponse>> get() = _onLoginUpdate
    fun onLoginPostValue(loginEntityResponse: LoginEntityResponse) {
        _onLoginUpdate.value = Event(loginEntityResponse)
    }
    //endregion

}